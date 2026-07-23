package net.bartoszciosek.kafkaorderprocessingsystem;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderProducer producer;

    public OrderController(OrderProducer orderProducer) {
        this.producer = orderProducer;
    }

    @PostMapping
    public String createOrder(@RequestBody OrderEvent event) {
        producer.sendOrder(event);
        return "Zamówienie wysłane";
    }
}