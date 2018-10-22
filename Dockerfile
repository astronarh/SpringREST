FROM tomcat:8.0.20-jre8

RUN mkdir /usr/local/tomcat/webapps/myapp

COPY /target/SpringREST.war /usr/local/tomcat/webapps/SpringREST.war
