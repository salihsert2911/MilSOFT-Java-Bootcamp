package com.godoro.buyit.rest;

import com.godoro.buyit.dto.CategoryDto;
import com.godoro.buyit.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<CategoryDto> getCategories() {
        return categoryService.list();
    }
}
