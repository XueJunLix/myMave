FROM java:8
VOLUME /tmp
ADD ur-ims-plan-1.jar app.jar
RUN bash -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Dloader.path=/springboot-lib/ -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]