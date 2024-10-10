FROM nginx:alpine

COPY ./nginx/default.conf /etc/nginx/conf.d/default.conf

RUN rm -rf /usr/share/nginx/html

COPY ../frontend/ /usr/share/nginx/html


CMD ["nginx", "-g", "daemon off;"]