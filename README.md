Basic project with java, gradle, spring boot and mongodb

Start
 ./gradlew bootRun
 
 start docker container mongdb
 docker run -d --name mongodb --restart always -p 27017:27017 -p 28017:28017 -e AUTH=no mongo:4.2.8
