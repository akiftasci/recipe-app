---
#Recipe App
You can add, update and delete your favorite recipes with this app.

---
##How to run
You can run the application by cloning it to your local and connecting to local database or with docker containers.
If you want to clone it just pull the [repository](https://github.com/akiftasci/abn-assessment) and change the `application.yml` with your mysql database
port. Run the following commands to create a jar file.

`mvn clean install`

Under the target folder run the jar file with `java -jar *.jar` command. The application should be ready on your local host port:`8080`(if the port is not already in use).

---
Docker
---
To run with docker pull the images from my dockerhub [repository](https://hub.docker.com/r/akifdev/recipe-app) with the following commands.

If you don`t have mysql and openjdk images in your local please pull these images first with:

- `docker pull mysql`
- `docker pull opendjk:8`

Create a container for database with the following command

- `docker run --name mysqldb -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=test -e MYSQL_USER=akif -e MYSQL_PASSWORD=password -d mysql`

Mysql database should be runing and you should be able to see it with `docker ps` command.

Pull the recipe app with `docker pull akifdev/recipe-app` and run the image with `docker run recipe-app`

---
##API Documentation
Please see the link below for the API documentation.

[You can find more information about the API.](https://documenter.getpostman.com/view/14143942/UVC9gkF4)

---
##Architechtural Choises
In my project I used layered architecture. The code is arranged, so the data enters the controller layer and
works its way down each layer until it reaches the bottom, which is database. Along the way, each layer has
a specific task, like checking the data for consistency or reformatting the values to keep them consistent.
---
##Author
*Akif Tasci*