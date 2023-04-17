package com.godoro.buyit.service;

import com.godoro.buyit.dto.CartDto;

import java.util.List;

public interface CartService {
    CartDto add(CartDto cartDto);

    CartDto change(CartDto cartDto);

    void delete(long cartId);

    CartDto find(long cartId);

    List<CartDto> list();
}
