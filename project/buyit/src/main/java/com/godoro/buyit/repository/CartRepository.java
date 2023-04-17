package com.godoro.buyit.repository;

import com.godoro.buyit.entity.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {
}
