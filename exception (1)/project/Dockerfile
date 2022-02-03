FROM openjdk:8
ADD target/scan-and-pay.jar scan-and-pay.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "scan-and-pay.jar"]