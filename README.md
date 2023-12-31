# Kafka with Spring Boot

```mermaid
classDiagram

class Topic{
    Partition 1 [M2, M3, M4, ...]
    Partition 2 [M5, M6, M7, ...]
    Partition 3 [M8, M9, ...]
    ...

    Zookeeper() A wrapper used to manage Kafka
    Offset() Different for each partition. Last consumed message number
    Order() Order within each partition is Maintained
}

class Consumer_Group{
    Consumer Instance 1
    Consumer Instance 2
    Consumer Instance 3
    Consumer Instance 4
    ...

    Group-Id() String
    Consumer-Instances() Multiple Instances within Each \n consumer group will be auto-configured to read only a \n specific Partition. Will be configured at initial Load.
}

class Producer{
    Topic
    Key
    Message
    Custom-Producer-Partitioner() Destination Partition can be targeted
}

Producer --|> Topic: M10
Topic --|> Consumer_Group: M1
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
