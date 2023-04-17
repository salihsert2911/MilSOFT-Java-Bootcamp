package com.godoro.buyit.dto;

import com.godoro.buyit.entity.Cart;
import com.godoro.buyit.entity.CartProduct;
import com.godoro.buyit.entity.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CartDto {
    private long cartId;
    private String customerName;
    private String cardNumber;
    private Cart.Status cartStatus;
    private List<CartProduct> productList;
    private List<Product> products;

    public CartDto(String customerName, String cardNumber, Cart.Status cartStatus) {
        this.customerName = customerName;
        this.cardNumber = cardNumber;
        this.cartStatus = cartStatus;
    }
}
