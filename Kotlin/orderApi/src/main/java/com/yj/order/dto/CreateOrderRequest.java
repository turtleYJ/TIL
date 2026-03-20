package com.yj.order.dto;

import java.math.BigDecimal;

public record CreateOrderRequest(
        String productName,
        BigDecimal price,
        int amount

) {
}
