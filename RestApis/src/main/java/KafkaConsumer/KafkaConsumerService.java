package KafkaConsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "csv-upload-topic", groupId = "my-group")
    public void listen(String message) {
        // Process the received message (e.g., handle CSV file upload)
        System.out.println("Received message: " + message);
        // Add your file processing logic here
    }
}

