package org.chousik;

import com.fastcgi.FCGIInterface;
import com.google.gson.Gson;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Server {

    private final DataService dataService;
    private final FCGIInterface fcgiInterface;
    private final Gson gson = new Gson();

    private static final String httpsResponsePattern = """
            HTTP/1.1 200 OK
            Content-Type: application/json
            Content-Length: %d
            
            %s
            """;

    private static final String answerJsonPattern = """
            {
                "inFlag": %b,
                "executionTime": "%s",
                "time": "%s"
            }
            """;
    private static final String httpsErrorPattern = """
            HTTP/1.1 400 BAD REQUEST
            Content-Type: application/json
            Content-Length: %d
            
            %s
            """;
    private static final String errorPattern = """
            {
                "error": "%s"
            }
            """;
    public Server(DataService dataService, FCGIInterface fcgiInterface){
        this.dataService = dataService;
        this.fcgiInterface = fcgiInterface;
    }

    public void start() throws IOException{
        for (;;){
            run();
        }
    }

    private void run() throws IOException {

        while (fcgiInterface.FCGIaccept() >= 0) {
            String kissCat = "\uD83D\uDE3D";
            try {
                long startTime = System.nanoTime();
                var request = this.readRequest();
                Data data = gson.fromJson(request, Data.class);
                if (dataService.valid(data)) {
                    var inFlag = dataService.check(data);
                    var answerJson = answerJsonPattern.formatted(inFlag, System.nanoTime() - startTime,
                            LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                    var httpsResponse = httpsResponsePattern.formatted(answerJson.getBytes(StandardCharsets.UTF_8).length, answerJson);
                    FCGIInterface.request.outStream.write(httpsResponse.getBytes(StandardCharsets.UTF_8));
                } else {
                    String funCAt = "\uD83D\uDE3A";
                    sendError("Введены невалидные данные!"+ funCAt);
                }
            }catch (NumberFormatException e){
                sendError("Котик, отправляй циферки в параметрах!"+ kissCat);
            }catch (NullPointerException e){
                sendError("Котик, ты кажется ничего не отправил в теле(!"+ kissCat);
            }catch (Exception e){
                String sadCat = "\uD83D\uDE3F";
                sendError("Неизвестная ошибка! Обратитесь к администратору сервера!"+ sadCat);
            }
        }
    }

    private void sendError(String message) throws IOException{
        var error = errorPattern.formatted(message);
        var httpsError = httpsErrorPattern.formatted(error.getBytes(StandardCharsets.UTF_8).length, error);
        FCGIInterface.request.outStream.write(httpsError.getBytes(StandardCharsets.UTF_8));
    }

    private String readRequest() throws IOException{
        FCGIInterface.request.inStream.fill();
        var contentLength = FCGIInterface.request.inStream.available();
        var buffer = ByteBuffer.allocate(contentLength);
        var readBytes =
                FCGIInterface.request.inStream.read(buffer.array(), 0,
                        contentLength);
        var requestBodyRaw = new byte[readBytes];
        buffer.get(requestBodyRaw);
        buffer.clear();
        return new String(requestBodyRaw, StandardCharsets.UTF_8);
    }
}
