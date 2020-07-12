FROM tomcat:latest
ADD ./wutfaces-1.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/
RUN chmod +x /usr/local/tomcat/bin/catalina.sh
CMD ["catalina.sh", "run"]
