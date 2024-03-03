package com.example.productorderservice.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productSerivce;

    @Test
    void 상품조회 () {
        // 상품등록
        productSerivce.addProduct(ProductSteps.상품등록요청_생성());
        final long productId = 1L;

        // 상품조회
        final GetProductResponse response = productSerivce.getProduct(productId);

        // 상품의 응답을 검증
        assertThat(response).isNotNull();
    }


}
