package ConsumerAndProduceInTextForm;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaProducerExample {

    public static void main(String[] args) {
        // Configure producer properties
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // Create Kafka producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        // Send a message to the topic
        String topic = "test-topic";
        String message = "Hello, Kafka!";
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, message);
        producer.send(record);

        // Close the producer
        producer.close();
    }
}
