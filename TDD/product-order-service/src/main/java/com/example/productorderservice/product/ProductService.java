package com.example.productorderservice.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
class ProductService {
    private final ProductPort productPort;

    public ProductService(final ProductPort productPort) {
        this.productPort = productPort;
    }

    @PostMapping
    @Transactional
    public ResponseEntity addProduct(@RequestBody AddProductRequest request) {
        final Product product = new Product(request.name(), request.price(), request.discountPolicy());
        productPort.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable final Long productId) {
        Product product = productPort.getProduct(productId);

        GetProductResponse response = new GetProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDiscountPolicy()
        );

        return ResponseEntity.ok(response);
    }
}