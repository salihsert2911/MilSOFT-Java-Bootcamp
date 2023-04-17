package com.godoro.buyit.service;

import com.godoro.buyit.dto.ProductDto;
import com.godoro.buyit.entity.Category;
import com.godoro.buyit.entity.Product;
import com.godoro.buyit.repository.CategoryRepository;
import com.godoro.buyit.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void add(ProductDto productDto) {
        productRepository.save(toEntity(productDto));
    }

    @Override
    public void change(ProductDto productDto) {
        productRepository.save(toEntity(productDto));
    }

    @Override
    public void delete(long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public ProductDto find(long productId) {
        Optional<Product> optional = productRepository.findById(productId);
        if (optional.isPresent()) {
            return toDto(optional.get());
        }
        return null;
    }

    @Override
    public List<ProductDto> list(long categoryId) {
        List<ProductDto> productDtoList = new ArrayList<>();
        Optional<Category> optional = categoryRepository.findById(categoryId);
        if (optional.isPresent()) {
            for (Product product : optional.get().getProductList()) {
                productDtoList.add(toDto(product));
            }
            return productDtoList;
        }
        return null;
    }

    public static Product toEntity(ProductDto productDto) {
        Product product = new Product();
        product.setProductId(productDto.getProductId());
        product.setProductName(productDto.getProductName());
        product.setSalesPrice(productDto.getSalesPrice());
        product.setImgPath(productDto.getImgPath());
        product.setCategory(productDto.getCategory());
        product.setCartList(productDto.getCartList());
        return product;
    }

    public static ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setProductName(product.getProductName());
        productDto.setSalesPrice(product.getSalesPrice());
        productDto.setImgPath(product.getImgPath());
        productDto.setCategory(product.getCategory());
        productDto.setCartList(product.getCartList());
        return productDto;
    }
}
