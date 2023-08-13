# Kafka with Spring Boot

## Install and Run with Docker Compose

<!-- prettier-ignore -->
- Download and start services

```javascript
docker compose -f .\docker-compose.yml up -d
```

- Check Status `docker images`, `docker ps`
- Open integrated terminal within container `docker exec -it kafka /bin/sh`
- Now within integrated terminal,
  > - `cd opt`
  > - `cd kafka_2.13-2.8.1`
  > - `cd bin`
  > - `ls`
  > - Now we see scripts related to each functionality
  > - Create a new Topic `kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic quickstart`, Notice it shows _Created topic quickstart_
  > - To Produce Messages `kafka-console-producer.sh --topic quickstart --bootstrap-server localhost:9092`, will open an internal command-line, we can enter messages there.
  > - To Consume Messages `kafka-console-consumer.sh --topic quickstart --from-beginning --bootstrap-server localhost:9092`

## [Offset Explorer 2.3.2](https://www.kafkatool.com/download.html)

- UI tool to interact with kafka
- open a cluster
- open topic properties
- Change content type of both Key and Value to `String`
  ś
