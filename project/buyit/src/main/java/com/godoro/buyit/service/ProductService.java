package com.godoro.buyit.service;

import com.godoro.buyit.dto.ProductDto;

import java.util.List;

public interface ProductService {
    void add(ProductDto productDto);

    void change(ProductDto productDto);

    void delete(long productId);

    ProductDto find(long productId);

    List<ProductDto> list(long categoryId);
}
