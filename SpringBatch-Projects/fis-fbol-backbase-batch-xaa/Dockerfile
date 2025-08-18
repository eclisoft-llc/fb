FROM openjdk:18-jdk-alpine

ENV CONFIG_PATH=/app/config/

RUN addgroup -S spring && adduser -S spring -G spring

# Directory for internal writing owned by spring
RUN mkdir -p /app/ignite && mkdir -p /app/config
RUN chown spring:spring /app/ignite /app/config

USER spring:spring
ARG module_path=./
ARG DEPENDENCY=${module_path}/target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

ARG JAVA_OPTS="--add-exports=java.base/jdk.internal.misc=ALL-UNNAMED \
 --add-exports=java.base/sun.nio.ch=ALL-UNNAMED \
 --add-exports=java.management/com.sun.jmx.mbeanserver=ALL-UNNAMED \
 --add-exports=jdk.internal.jvmstat/sun.jvmstat.monitor=ALL-UNNAMED \
 --add-exports=java.base/sun.reflect.generics.reflectiveObjects=ALL-UNNAMED \
 --add-opens=jdk.management/com.sun.management.internal=ALL-UNNAMED \
 --illegal-access=permit"

ENTRYPOINT ["sh","-c","java $JAVA_OPTS -XX:+UseContainerSupport -cp app:app/lib/* $MAIN_CLASS"]