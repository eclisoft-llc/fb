FROM openjdk:18-jdk-alpine

ENV CONFIG_PATH=/app/config/

RUN addgroup -S spring && adduser -S spring -G spring

# Directory for internal writing owned by spring
RUN mkdir -p /app/ignite && mkdir -p /app/config
RUN chown spring:spring /app/ignite /app/config
# COPY "data-encryption-certificate.cer" ${JAVA_HOME}/lib/security/

COPY "dih_rdy_cert_intermediate.cer" ${JAVA_HOME}/lib/security/
COPY "dih_rdy_cert_root.cer" ${JAVA_HOME}/lib/security/
COPY "pinpoint.uat.firstbanks.net.2.pfx" ${JAVA_HOME}/lib/security/
COPY "434c5606d1e2d69a.crt" ${JAVA_HOME}/lib/security/
RUN \
    cd ${JAVA_HOME}/lib/security/ \
	&& ls \
	&& keytool -importkeystore -srckeystore pinpoint.uat.firstbanks.net.2.pfx -srcstoretype PKCS12 -srcstorepass Why1 -destkeystore pinpoint.uat.firstbanks.net.3.pfx -deststoretype PKCS12 -deststorepass ucicfbol
RUN \
    cd ${JAVA_HOME}/lib/security/ \
	&& ls \
	&& keytool -importcert -alias dih_rdy_cert_intermediate -file dih_rdy_cert_intermediate.cer -storepass ucicfbol -keystore /app/client-app2.jks -trustcacerts -noprompt \
	&& keytool -importcert -alias dih_rdy_cert_root -file dih_rdy_cert_root.cer -storepass ucicfbol -keystore /app/client-app2.jks -trustcacerts -noprompt \
	&& keytool -importkeystore -alias te-7aae8ce3-9a0a-41f9-9caa-9cf6c3facc76 -srckeystore pinpoint.uat.firstbanks.net.3.pfx -srcstoretype pkcs12 -destkeystore /app/client-app2.jks -deststoretype JKS -destalias firstbank -deststorepass ucicfbol -srcstorepass ucicfbol



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