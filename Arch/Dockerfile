FROM eclipse-temurin:25-jre
COPY target/Arch-0.0.1.war /tmp/Arch-0.0.1.war
EXPOSE 8081
ENTRYPOINT ["java","-Duser.timezone=UTC","-jar","/tmp/Arch-0.0.1.war"]
