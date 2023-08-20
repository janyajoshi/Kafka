package com.lazybeast.sampleKafka.config;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomProducerPartitioner implements Partitioner {

//    to keep record of last partition in which message was sent
    private final AtomicInteger counter = new AtomicInteger(0);


    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        List<PartitionInfo> partitions = cluster.partitionsForTopic(topic);
        return customPartitionIndex(partitions.size());
    }

    private int customPartitionIndex(int numPartitions) {
        // Get the next partition index using round-robin approach
        int nextPartitionIndex = counter.getAndIncrement() % numPartitions;

        // Wrap around the index if it exceeds the number of partitions
        if (nextPartitionIndex < 0) {
            counter.set(0);
            nextPartitionIndex = 0;
        }

        return nextPartitionIndex;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
