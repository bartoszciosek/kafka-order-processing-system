package net.bartoszciosek.kafkaorderprocessingsystem;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class KafkaOrderProcessingSystemApplication {

    static void main(String[] args) {
        run(KafkaOrderProcessingSystemApplication.class, args);
    }
}