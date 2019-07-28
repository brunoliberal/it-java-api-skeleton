FROM vidolin/openjdk:11-jre-tz-alpine

ENV SPRING_PROFILE=notset

COPY ./api.jar /opt/api.jar

ENTRYPOINT exec java -jar -Dspring.profiles.active="${SPRING_PROFILE}" /opt/api.jar