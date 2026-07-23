package net.bartoszciosek.kafkaorderprocessingsystem;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static java.lang.IO.println;

@Service
public class OrderProducer {

    private static final String TOPIC = "orders-topic";
    private final KafkaTemplate<String, OrderEvent> template;

    public OrderProducer(KafkaTemplate<String, OrderEvent> template) {
        this.template = template;
    }

    public void sendOrder(OrderEvent orderEvent) {
        template.send(TOPIC, orderEvent.orderId(), orderEvent);
        println("⚡ [PRODUCER] Wysyłam zamówienie do Kafki: " + orderEvent);
    }
}