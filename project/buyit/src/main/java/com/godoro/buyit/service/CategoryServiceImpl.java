package com.godoro.buyit.service;

import com.godoro.buyit.dto.CategoryDto;
import com.godoro.buyit.entity.Category;
import com.godoro.buyit.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void add(CategoryDto categoryDto) {
        categoryRepository.save(toEntity(categoryDto));
    }

    @Override
    public void change(CategoryDto categoryDto) {
        categoryRepository.save(toEntity(categoryDto));
    }

    @Override
    public void delete(long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public CategoryDto find(long categoryId) {
        Optional<Category> optional = categoryRepository.findById(categoryId);
        if (optional.isPresent()) {
            return toDto(optional.get());
        }
        return null;
    }

    @Override
    public List<CategoryDto> list() {
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for (Category category : categoryRepository.findAll()) {
            categoryDtoList.add(toDto(category));
        }
        return categoryDtoList;
    }

    public Category toEntity(CategoryDto categoryDto) {
        Category category = new Category();
        category.setCategoryId(categoryDto.getCategoryId());
        category.setCategoryName(categoryDto.getCategoryName());
        category.setProductList(categoryDto.getProductList());
        return category;
    }

    public CategoryDto toDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryId(category.getCategoryId());
        categoryDto.setCategoryName(category.getCategoryName());
        categoryDto.setProductList(category.getProductList());
        return categoryDto;
    }
}
