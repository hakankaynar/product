FROM adoptopenjdk:11-jre-hotspot

RUN mkdir /opt/app

COPY product.jar /opt/app

EXPOSE 8080

CMD ["java", "-jar", "/opt/app/product.jar"]