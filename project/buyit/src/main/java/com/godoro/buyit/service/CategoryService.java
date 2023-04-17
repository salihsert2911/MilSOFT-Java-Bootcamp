package com.godoro.buyit.service;

import com.godoro.buyit.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    void add(CategoryDto categoryDto);

    void change(CategoryDto categoryDto);

    void delete(long categoryId);

    CategoryDto find(long categoryId);

    List<CategoryDto> list();
}
