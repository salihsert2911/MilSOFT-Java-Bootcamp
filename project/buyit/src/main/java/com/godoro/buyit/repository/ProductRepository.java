package com.godoro.buyit.repository;

import com.godoro.buyit.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
