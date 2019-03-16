#!/bin/sh

exec java -jar -Dspring.datasource.url="jdbc:mysql://hectorh-mysql-service:3306/test" app.jar