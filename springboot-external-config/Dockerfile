FROM java:8u92-oracle

COPY target/springboot-external-config-1.0-SNAPSHOT.jar /opt/springboot-external-config-1.0-SNAPSHOT.jar

ADD config/ /opt/config/

WORKDIR /opt

ENV SPRING_APPLICATION_JSON='{"spring.profiles.active":"local","property.five":"Value Five","property.six":"Value Six","property.seven":"Value Seven"}'

CMD ["java","-jar","springboot-external-config-1.0-SNAPSHOT.jar"]