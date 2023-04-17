package com.godoro.buyit.service;

import com.godoro.buyit.dto.CartDto;
import com.godoro.buyit.entity.Cart;
import com.godoro.buyit.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


    @Override
    public CartDto add(CartDto cartDto) {
        return toDto(cartRepository.save(toEntity(cartDto)));
    }

    @Override
    public CartDto change(CartDto cartDto) {
        return toDto(cartRepository.save(toEntity(cartDto)));
    }

    @Override
    public void delete(long cartId) {
        cartRepository.deleteById(cartId);
    }

    @Override
    public CartDto find(long cartId) {
        Optional<Cart> optional = cartRepository.findById(cartId);
        if (optional.isPresent()) {
            return toDto(optional.get());
        }
        return null;
    }

    @Override
    public List<CartDto> list() {
        List<CartDto> cartDtoList = new ArrayList<>();
        for (Cart cart : cartRepository.findAll()) {
            cartDtoList.add(toDto(cart));
        }
        return cartDtoList;
    }

    public static Cart toEntity(CartDto cartDto) {
        Cart cart = new Cart();
        cart.setCartId(cartDto.getCartId());
        cart.setCustomerName(cartDto.getCustomerName());
        cart.setCardNumber(cartDto.getCardNumber());
        cart.setCartStatus(cartDto.getCartStatus());
        cart.setProductList(cartDto.getProductList());
        return cart;
    }

    public static CartDto toDto(Cart cart) {
        CartDto cartDto = new CartDto();
        cartDto.setCartId(cart.getCartId());
        cartDto.setCustomerName(cart.getCustomerName());
        cartDto.setCardNumber(cart.getCardNumber());
        cartDto.setCartStatus(cart.getCartStatus());
        cartDto.setProductList(cart.getProductList());
        return cartDto;
    }

}
