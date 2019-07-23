docker-compose -f ./dockercompose/docker-compose.yml down
mvn clean package -DskipTests=true
mv ./target/spring-integration-test-1.0-SNAPSHOT-exec.jar /home/extmas3p/Omkar/integrationtest/dockercompose/app/myapp.jar
cp -R ./src/test/* /home/extmas3p/Omkar/integrationtest/dockercompose/testing/testSource/src/
cp pom.xml /home/extmas3p/Omkar/integrationtest/dockercompose/testing/testSource/
docker-compose -f ./dockercompose/docker-compose.yml build
nohup docker-compose -f ./dockercompose/docker-compose.yml up &
chmod -R 777 *
