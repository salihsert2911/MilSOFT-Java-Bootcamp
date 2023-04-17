package com.godoro.buyit.rest;

import com.godoro.buyit.dto.CartDto;
import com.godoro.buyit.dto.CartProductDto;
import com.godoro.buyit.dto.ProductDto;
import com.godoro.buyit.entity.Cart;
import com.godoro.buyit.entity.CartProduct;
import com.godoro.buyit.entity.Product;
import com.godoro.buyit.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    private CartService cartService;
    private ProductService productService;
    private CartProductService cartProductService;

    public CartController(CartService cartService, ProductService productService, CartProductService cartProductService) {
        this.cartService = cartService;
        this.productService = productService;
        this.cartProductService = cartProductService;
    }

    @GetMapping("/get/{id}")
    public CartDto getCart(@PathVariable("id") long cartId) {
        CartDto cartDto = cartService.find(cartId);
        if (cartDto == null) {
            CartDto cartDto1 = new CartDto("godoro", "12345", Cart.Status.NEW);
            cartDto = cartService.add(cartDto1);
            return cartService.find(cartDto.getCartId());
        }

        List<Product> products = new ArrayList<>();
        for (CartProduct cartProduct : cartDto.getProductList()) {
            products.add(cartProduct.getProduct());
        }
        cartDto.setProducts(products);
        return cartDto;
    }

    @PostMapping("/add/{cartid}/{productid}")
    public CartDto addToCart(@PathVariable("cartid") long cartId, @PathVariable("productid") long productId, @RequestBody CartProductDto cartProductDto) {
        CartDto cartDto = cartService.find(cartId);
        ProductDto productDto = productService.find(productId);
        for (CartProduct cartProduct : cartDto.getProductList()) {
            if (cartProduct.getCart().equals(CartServiceImpl.toEntity(cartDto)) &&
                    cartProduct.getProduct().equals(ProductServiceImpl.toEntity(productDto))) {
                cartProduct.setSalesQuantity(cartProduct.getSalesQuantity() + cartProductDto.getSalesQuantity());
                cartProductService.change(CartProductServiceImpl.toDto(cartProduct));
                return cartDto;
            }
        }
        cartProductDto.setCart(CartServiceImpl.toEntity(cartDto));
        cartProductDto.setProduct(ProductServiceImpl.toEntity(productDto));
        cartProductService.add(cartProductDto);
        return cartDto;
    }

    @DeleteMapping("/remove/{cartid}/{productid}")
    public CartDto removeFromCart(@PathVariable("cartid") long cartId, @PathVariable("productid") long productId) {
        CartDto cartDto = cartService.find(cartId);
        ProductDto productDto = productService.find(productId);
        for (CartProduct cartProduct : cartDto.getProductList()) {
            if (cartProduct.getCart().equals(CartServiceImpl.toEntity(cartDto)) &&
                    cartProduct.getProduct().equals(ProductServiceImpl.toEntity(productDto))) {
                cartDto.getProductList().remove(cartProduct);
                productDto.getCartList().remove(cartProduct);
                cartProduct.setCart(null);
                cartProduct.setProduct(null);
                return cartService.change(cartDto);
            }
        }
        return null;
    }

    @PutMapping("/checkout")
    public CartDto updateCart(@RequestBody CartDto cartDto) {
        CartDto cartDto1 = cartService.find(cartDto.getCartId());
        cartDto1.setCartStatus(Cart.Status.COMPLETED);
        cartDto1.setCustomerName(cartDto.getCustomerName());
        cartDto1.setCardNumber(cartDto.getCardNumber());
        cartDto1.getProductList().clear();
        return cartService.change(cartDto1);
    }
}
