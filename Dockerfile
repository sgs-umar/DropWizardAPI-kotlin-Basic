FROM openjdk:21-jdk
COPY docker_config.yml /opt/kotlinApps/
COPY app/build/libs/app-all.jar /opt/kotlinApps/
EXPOSE 8001
WORKDIR /opt/kotlinApps/
CMD ["java", "-jar", "-Done-jar.silent=true", "app-all.jar", "server", "docker_config.yml"]