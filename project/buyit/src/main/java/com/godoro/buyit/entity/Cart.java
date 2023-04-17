package com.godoro.buyit.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Cart {

    public enum Status {
        NEW,
        COMPLETED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;
    private String customerName;
    private String cardNumber;
    @Enumerated(EnumType.ORDINAL)
    private Status cartStatus;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "cart-cartproduct")
    private List<CartProduct> productList;

    public Cart(String customerName, String cardNumber, Status cartStatus) {
        this.customerName = customerName;
        this.cardNumber = cardNumber;
        this.cartStatus = cartStatus;
    }

}