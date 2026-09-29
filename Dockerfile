FROM tomcat:10.1-jdk21-temurin

LABEL maintainer="Hotel Service Portal"

RUN rm -rf /usr/local/tomcat/webapps/*

COPY target/hotel-service-portal.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
