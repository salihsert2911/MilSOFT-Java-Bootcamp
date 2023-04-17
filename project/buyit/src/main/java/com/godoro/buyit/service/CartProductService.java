package com.godoro.buyit.service;

import com.godoro.buyit.dto.CartProductDto;

import java.util.List;

public interface CartProductService {
    CartProductDto add(CartProductDto cartProductDto);

    CartProductDto change(CartProductDto cartProductDto);

    void delete(long cartProductId);

    CartProductDto find(long cartProductId);

    List<CartProductDto> list();
}
