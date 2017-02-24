FROM reg.ipebg.efoxconn.com/library/centos:6.8
VOLUME /tmp
ADD eureka-server-1.0-SNAPSHOT.jar /app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8761
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]