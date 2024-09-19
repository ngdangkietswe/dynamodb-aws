package dev.ngdangkietswe.dynamodbaws.apis;

import dev.ngdangkietswe.dynamodbaws.domains.product.dtos.responses.ProductDto;
import dev.ngdangkietswe.dynamodbaws.domains.product.entities.Product;
import dev.ngdangkietswe.dynamodbaws.domains.product.services.impls.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ngdangkietswe
 * @since 9/15/2024
 */

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody Product payload) {
        productService.save(payload);
        return ResponseEntity.ok("Product created successfully");
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProduct() {
        return ResponseEntity.ok(productService.findAll());
    }
}
