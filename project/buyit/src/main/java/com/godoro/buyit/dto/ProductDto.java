package com.godoro.buyit.dto;

import com.godoro.buyit.entity.CartProduct;
import com.godoro.buyit.entity.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductDto {
    private long productId;

    private String productName;
    private double salesPrice;
    private String imgPath;

    private Category category;

    private List<CartProduct> cartList;

    public ProductDto(String productName, double salesPrice) {
        this.productName = productName;
        this.salesPrice = salesPrice;
    }
}
