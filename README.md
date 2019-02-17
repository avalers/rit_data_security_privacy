# rit_data_security_privacy
Technologies used Spring Framework and Java 8
Setup the development environment:

Download the MySQL Community Server 5.7.17 or latest
https://dev.mysql.com/downloads/mysql/

2) Execute the SQL Scripts  in the MySQL Workbench
a)Create the user for the application.
CREATE USER 'ritCourses'@'localhost' IDENTIFIED BY 'Rit@2018';
 GRANT SELECT
    	ON securedb.* TO ritCourses@'localhost'
 WITH GRANT OPTION;

b)Execute the schema:
Create schema securedb
c)create the tables in the schema securedb:
Dump20170510.sql

3) Download the STS(Spring tool suite) as IDE 
https://spring.io/blog/2016/12/22/spring-tool-suite-3-8-3-released

4) Download the JDK 1.8
http://www.oracle.com/technetwork/java/javase/downloads/java-archive-javase8-2177648.html#jdk-8u121-oth-JPR


5)Download the Source code from github repository
https://github.com/avalers/rit_data_security_privacy


6)Open STS and Import the project downloaded from github into the STS
7)To execute the project:
Click right on the project -> Run as -> Spring Boot App

