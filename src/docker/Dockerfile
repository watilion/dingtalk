FROM openjdk:8-jre
MAINTAINER wutenglong <wutenglong@zeiet.com>
VOLUME /tmp
ADD dingtalk-0.0.1-SNAPSHOT.jar dingtalk.jar
#RUN bash -c 'touch /iep-event.jar'
EXPOSE 8093
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/dingtalk.jar"]