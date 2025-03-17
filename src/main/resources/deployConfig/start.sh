#!/bin/bash

service mysql start
service nginx start
nohup java -jar /var/www/DemoForDeviceAtlas/DemoForDeviceAtlas.jar &

tail -f /dev/null
