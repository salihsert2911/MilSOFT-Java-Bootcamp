package com.godoro.buyit.dto;

import com.godoro.buyit.entity.Cart;
import com.godoro.buyit.entity.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartProductDto {
    private long cartProductId;

    private Cart cart;

    private Product product;
    private long salesQuantity;
}
