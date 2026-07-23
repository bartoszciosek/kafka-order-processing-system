package net.bartoszciosek.kafkaorderprocessingsystem;

import java.math.BigDecimal;

public record OrderEvent(
        String orderId,
        String customerId,
        String product,
        BigDecimal price,
        int quantity
) {}