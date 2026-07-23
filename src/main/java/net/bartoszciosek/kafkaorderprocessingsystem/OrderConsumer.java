package net.bartoszciosek.kafkaorderprocessingsystem;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.IO.println;

@Service
public class OrderConsumer {

    @KafkaListener(topics = "orders-topic", groupId = "order-notification-group")
    public void consume(OrderEvent event) {
        println("Odebrano wiadomość");
        println("Zamówienie ID: " + event.orderId());
        println("Klient ID: " + event.customerId());
        println("Produkt: " + event.product());
        println("Cena: " + event.price());
    }
}