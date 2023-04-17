package com.godoro.buyit.rest;

import com.godoro.buyit.dto.ProductDto;
import com.godoro.buyit.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public ProductDto getProduct(@PathVariable("id") long productId) {
        return productService.find(productId);
    }

    @GetMapping("/products/{categoryId}")
    public List<ProductDto> getProducts(@PathVariable("categoryId") long categoryId) {
        return productService.list(categoryId);
    }
}
