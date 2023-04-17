package com.godoro.buyit.service;

import com.godoro.buyit.dto.CartProductDto;
import com.godoro.buyit.entity.CartProduct;
import com.godoro.buyit.repository.CartProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartProductServiceImpl implements CartProductService {
    CartProductRepository cartProductRepository;

    public CartProductServiceImpl(CartProductRepository cartProductRepository) {
        this.cartProductRepository = cartProductRepository;
    }

    @Override
    public CartProductDto add(CartProductDto cartProductDto) {
        return toDto(cartProductRepository.save(toEntity(cartProductDto)));
    }

    @Override
    public CartProductDto change(CartProductDto cartProductDto) {
        return toDto(cartProductRepository.save(toEntity(cartProductDto)));
    }

    @Override
    public void delete(long cartProductId) {
        cartProductRepository.deleteById(cartProductId);
    }

    @Override
    public CartProductDto find(long cartProductId) {
        Optional<CartProduct> optional = cartProductRepository.findById(cartProductId);
        if (optional.isPresent()) {
            return toDto(optional.get());
        }
        return null;
    }

    @Override
    public List<CartProductDto> list() {
        List<CartProductDto> cartProductDtoList = new ArrayList<>();
        for (CartProduct cartProduct : cartProductRepository.findAll()) {
            cartProductDtoList.add(toDto(cartProduct));
        }
        return cartProductDtoList;
    }

    public static CartProduct toEntity(CartProductDto cartProductDto) {
        CartProduct cartProduct = new CartProduct();
        cartProduct.setCartProductId(cartProductDto.getCartProductId());
        cartProduct.setCart(cartProductDto.getCart());
        cartProduct.setProduct(cartProductDto.getProduct());
        cartProduct.setSalesQuantity(cartProductDto.getSalesQuantity());
        return cartProduct;
    }

    public static CartProductDto toDto(CartProduct cartProduct) {
        CartProductDto cartProductDto = new CartProductDto();
        cartProductDto.setCartProductId(cartProduct.getCartProductId());
        cartProductDto.setCart(cartProduct.getCart());
        cartProductDto.setProduct(cartProduct.getProduct());
        cartProductDto.setSalesQuantity(cartProduct.getSalesQuantity());
        return cartProductDto;
    }
}
