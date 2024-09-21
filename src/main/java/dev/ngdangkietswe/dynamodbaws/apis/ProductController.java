package dev.ngdangkietswe.dynamodbaws.apis;

import dev.ngdangkietswe.dynamodbaws.domains.common.responses.BaseResponse;
import dev.ngdangkietswe.dynamodbaws.domains.product.dtos.ProductDto;
import dev.ngdangkietswe.dynamodbaws.domains.product.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public BaseResponse<String> upsertProduct(@RequestBody ProductDto payload) {
        try {
            String id = productService.save(payload);
            return BaseResponse.asSuccess(id);
        } catch (Exception e) {
            return BaseResponse.asError(e);
        }
    }

    @GetMapping
    public BaseResponse<List<ProductDto>> getProduct() {
        var products = productService.findAll();
        return BaseResponse.asSuccess(products);
    }

    @GetMapping("/{id}")
    public BaseResponse<ProductDto> getProductById(@PathVariable String id) {
        try {
            var product = productService.findById(id);
            return BaseResponse.asSuccess(product);
        } catch (Exception e) {
            return BaseResponse.asError(e);
        }
    }

    @DeleteMapping("/{id}")
    public BaseResponse<String> deleteProductById(@PathVariable String id) {
        try {
            productService.deleteById(id);
            return BaseResponse.asSuccess();
        } catch (Exception e) {
            return BaseResponse.asError(e);
        }
    }
}
