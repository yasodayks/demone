FROM openjdk:8-jdk-alpine
LABEL maintainer="yasoda.yks@gmail.com"

# Add a volume pointing to /tmp
#VOLUME /tmp

# Make port 2020 available to the world outside this container
EXPOSE 2030

# The application's jar file
#ARG JAR_FILE=target/demone-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
#ADD ${JAR_FILE} demone-0.0.1-SNAPSHOT.jar

COPY ./target/demone-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch demone-0.0.1-SNAPSHOT.jar'

# Run the jar file 
ENTRYPOINT ["java","-jar","/demone-0.0.1-SNAPSHOT.jar"]