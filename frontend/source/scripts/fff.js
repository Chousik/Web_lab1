const table = `<tr id="head-table">
                    <td>x</td>
                    <td>y</td>
                    <td>r</td>
                    <td>status</td>
                    <td>current time</td>
                    <td>script runtime</td>
                </tr>
                `

$(document).ready(function() {
    $ ("#check_button").click(function() {
        if (validateAll()){
            let radios = document.querySelector('input[type=radio]:checked');
            let elementY = document.getElementById("Y_input");
            let elementR = document.getElementById("R_input");

            let xValue = parseFloat(radios.value).toFixed(0)
            let yValue = parseFloat(elementY.value.replace(',', '.')).toFixed(1)
            let rValue = parseFloat(elementR.value.replace(',', '.')).toFixed(1)

            const request = {
                method: "POST",
                headers: {"content-type": "application/json",},

                body: JSON.stringify({
                    x: xValue,
                    y: yValue,
                    r: rValue
                })

            };
            fetch("/api/",
                request)
                .then(response => response.json())
                .then(dataJson => {
                    const newRow = document.createElement('tr');
                    newRow.innerHTML = `
                    <td>${xValue}</td>
                    <td>${yValue}</td>
                    <td>${rValue}</td>
                    <td>${dataJson.inFlag ? "Есть пробитие!":
                        "Рикошет!"}</td>
                    <td>${dataJson.time}</td>
                    <td>${dataJson.executionTime}</td>
                    `
                    $("#result_table").append(newRow)
                })
                .catch(error => console.error('Error:', error));
        }
    })
    $("#clear_button").click(function() {
        $("#result_table").html(table);
    });
})