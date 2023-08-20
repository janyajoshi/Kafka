# Kafka with Spring Boot

```mermaid
classDiagram
A--|>B
```

## Install and Run Kafka and Zookeeper with Docker Compose

- Download and start services

```cmd
docker compose -f .\docker-compose.yml up -d
```

- Check Status `docker images`, `docker ps`
- Open integrated terminal within container

```cmd
docker exec -it kafka /bin/sh
```

- Now within integrated terminal,

```cmd
cd opt/kafka_2.13-2.8.1/bin;ls
```

- Create a new Topic, it will show _Created topic quickstart_ after successful creation

```cmd
kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic quickstart
```

- To Produce Messages, the command will open an internal command-line, we can enter messages there.

```cmd
kafka-console-producer.sh --topic quickstart --bootstrap-server localhost:9092
```

- To Consume Messages

```cmd
kafka-console-consumer.sh --topic quickstart --from-beginning --bootstrap-server localhost:9092
```

## [Offset Explorer 2.3.2](https://www.kafkatool.com/download.html)

- UI tool to interact with kafka
- open a cluster
- open topic properties
- Change content type of both Key and Value to `String`

## Sample Producer and Consumer

- [Producer Config](sample-kafka-producer-consumer/src/main/java/com/lazybeast/sampleKafka/config/KafkaProducerConfig.java)
- [Consumer Config](sample-kafka-producer-consumer/src/main/java/com/lazybeast/sampleKafka/config/KafkaConsumerConfig.java)
- [Demo Service](sample-kafka-producer-consumer/)
