FROM ubuntu

# disable interaction during apt install
ENV DEBIAN_FRONTEND=noninteractive

# install environment needed
RUN apt-get update \
    && apt-get install -y \
    apt-utils \
    mysql-server \
    openjdk-17-jdk \
    nginx \
    nano \
    && apt-get clean

# copy project file
COPY ./frontend /var/www/DemoForDeviceAtlas/frontend/
COPY ./DemoForDeviceAtlas.jar /var/www/DemoForDeviceAtlas/

# copy nginx config file and delete the default one
RUN rm -f /etc/nginx/sites-enabled/default
COPY DemoForDeviceAtlas.conf /etc/nginx/sites-enabled/

# init mysql and alter auth plugin for root to mysql_native_password that allow backend to connect
COPY ./DemoForDeviceAtlas.sql /var/www/DemoForDeviceAtlas/
RUN service mysql start && \
    mysql < /var/www/DemoForDeviceAtlas/DemoForDeviceAtlas.sql && \
    mysql -e "ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY '';"

# copy start script and add execution permission
COPY ./start.sh /var/www/DemoForDeviceAtlas/
RUN chmod +x /var/www/DemoForDeviceAtlas/start.sh

# automatically run a container after image built
ENTRYPOINT ["/var/www/DemoForDeviceAtlas/start.sh"]
