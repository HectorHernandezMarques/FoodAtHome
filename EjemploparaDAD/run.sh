#!/bin/sh
while ! nc -z hectorh-mysql-service 3306 ; do
    echo "Waiting for MySQL server to be available"
    sleep 2
done

exec java -jar -Dspring.datasource.url=jdbc:mysql://hectorh-mysql-service/test app.jar