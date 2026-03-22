package com.yj.order.controller;

import com.yj.order.dto.CreateOrderRequest;
import com.yj.order.dto.OrderResponse;
import com.yj.order.entity.Order;
import com.yj.order.entity.OrderStatus;
import com.yj.order.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody CreateOrderRequest createOrderRequest) {
        Order order = orderService.createOrder(createOrderRequest);
        return ResponseEntity.ok(OrderResponse.from(order));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable Long id) {
        Order order = orderService.getOrder(id);
        return ResponseEntity.ok(OrderResponse.from(order));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OrderResponse> updateStatus(@PathVariable Long id, @RequestParam OrderStatus status) {
        Order order = orderService.updateStatus(id, status);
        return ResponseEntity.ok(OrderResponse.from(order));
    }
}
