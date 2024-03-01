package com.example.productorderservice.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;
    @Test
    void 상품등록() {
        final AddProductRequest request = 상품등록_요청();
        productService.addProduct(request);
    }

    private static AddProductRequest 상품등록_요청() {
        final String name = "상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final AddProductRequest request = new AddProductRequest(name, price, discountPolicy.NONE);
        return request;
    }

}
