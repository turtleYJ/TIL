package com.example.productorderservice.payment;

import com.example.productorderservice.order.Order;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@Entity
@Table(name = "payments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Order order;
    private String cardNumber;

    public Payment(final Order order, final String cardNumber) {
        Assert.notNull(order, "주문은 필수입니다.");
        Assert.notNull(cardNumber, "카드 번호는 필수입니다.");
        this.order = order;
        this.cardNumber = cardNumber;
    }

    public int getPrice() {
        return order.getTotalPrice();
    }

    public String getCardNumber() {
        return cardNumber;
    }
}


