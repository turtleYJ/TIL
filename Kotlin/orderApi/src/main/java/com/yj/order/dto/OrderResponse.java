package com.yj.order.dto;

import com.yj.order.entity.Order;
import com.yj.order.entity.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderResponse(
        Long orderId,
        String productName,
        BigDecimal price,
        OrderStatus status,
        int amount,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static OrderResponse from(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getProductName(),
                order.getPrice(),
                order.getOrderStatus(),
                order.getAmount(),
                order.getCreatedAt(),
                order.getUpdatedAt()
        );
    }
}
