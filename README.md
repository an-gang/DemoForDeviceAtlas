# DemoForDeviceAtlas

This application using Java SpringBoot, Mybatis and Mysql for back-end, React with Hooks for front-end and antd component library for its styling.

A live demo can be found at: http://194.26.213.114/

The application can also be modified and redeployed following the instructions below.

### Run with Docker

All the configuration files needed is under folder "config". Back-end package and front-end folder are also needed. There should be 5 files and 1 folder used for starting the application:

1. DemoForDeviceAtlas.jar ---- back end packaged with Maven and renamed to DemoForDeviceAtlas.jar. configured to use port 8080 and allow access only from localhost, can be modified in src/main/resources/application.yml
2. frontend ---- build folder built with npm and renamed to frontend, change IP address in front-end/src/framework/http.js to your server. The front-end runs on port 80, which can be changed in package.json
3. DemoForDeviceAtlas.conf ---- Nginx config, change the IP inside and port using if needed
4. DemoForDeviceAtlas.sql ---- database backup, include database, table and data
5. Dockerfile ---- Docker image build script
6. start.sh ---- auto start script

Place all these files in the same directory on a server with Docker installed and run command below to build Docker image. It will use the Dockerfile under path ./ to install all the environment needed into image include Mysql, java17 and Nginx. It will also copy other files needed into image and configure them

```
docker build -t demo-for-device-atlas ./
```
After image built, run a container with image built using the command below. An ENTRYPOINT is configured to this image, every time it starts, it will run the services needed and the application automatically.

```
docker run -d -p 80:80 --name demo-container demo-for-device-atlas
```

Now, the application should be deployed.

### Deploy manually

If anything goes wrong or Docker is not installed, the project can also be deployed manually. 

1. Using DemoForDeviceAtlas.sql to create database and table. "utf8mb4_0900_ai_ci" may not fit very old version Mysql, if happened, can change to use "utf8" and "utf8_general_ci"
2. Config the database connection in src/main/resources/application.yml. Current config only accept request from localhost which can also be commented out in this file. The back-end can be run locally by executing src/main/java/com/gangan/demofordeviceatlas/DemoForDeviceAtlasApplication or packaged into a .jar file with Maven.
3. By config baseURL in front-end/src/framework/http.js, Front-end can run locally with npm and connected to back-end directly without Nginx. Current setting using port 80 which can be changed in package.json
