package com.yj.order.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String productName;

    @Column
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column
    private OrderStatus orderStatus;

    @Column
    private int amount;

    @CreatedDate
    @Column
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column
    private LocalDateTime updatedAt;

    public Order(String productName, BigDecimal price, int amount) {
        if (price.compareTo(BigDecimal.ZERO) <= 0 || amount <= 0) {
            throw new IllegalArgumentException("가격 혹은 수량은 0보다 커야 합니다.");
        }

        this.productName = productName;
        this.price = price;
        this.amount = amount;
        this.orderStatus = OrderStatus.ORDERED;
    }

    public Order changeStatus(OrderStatus status) {
        validateTransition(status);
        this.orderStatus = status;
        return this;
    }

    private void validateTransition(OrderStatus toStatus) {
        List<OrderStatus> allowList = switch (this.orderStatus) {
            case ORDERED -> List.of(OrderStatus.PAYED, OrderStatus.CANCELLED);
            case PAYED -> List.of(OrderStatus.SHIPPING, OrderStatus.CANCELLED);
            case SHIPPING ->List.of(OrderStatus.DELIVERED);
            default -> List.of();
        };

        if (!allowList.contains(toStatus)) {
            throw new IllegalArgumentException("지원되지 않는 상태 변경입니다: " + this.orderStatus + "->" + toStatus);
        }
    }
}
