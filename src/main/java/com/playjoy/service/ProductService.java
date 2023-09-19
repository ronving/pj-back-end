package com.playjoy.service;

import com.playjoy.api.types.Product;
import com.playjoy.entity.ProductEntity;
import com.playjoy.enums.Category;
import com.playjoy.exception.ProductNotFoundException;
import com.playjoy.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductEntity findProduct(Long id) {
        return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    public Page<ProductEntity> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Page<ProductEntity> findByCategory(Category category, Pageable pageable) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                                               .withMatcher("categories", ExampleMatcher.GenericPropertyMatchers.contains());

        ProductEntity exampleEntity = new ProductEntity().setCategories(Collections.singletonList(category));
        Example<ProductEntity> example = Example.of(exampleEntity, matcher);

        return productRepository.findAll(example, pageable);
    }

    public ProductEntity addProduct(Product product) {
        ProductEntity productEntity = new ProductEntity()
                .setProductName(product.getProductName())
                .setDescription(product.getDescription())
                .setCategories(product.getCategories())
                .setTags(product.getTags())
                .setIconUrl(product.getIconUrl())
                .setPreviewUrl(product.getPreviewUrl())
                .setImagesUrl(product.getImagesUrl());

        return productRepository.save(productEntity);
    }

    //    ToDo:
    public ProductEntity updateProduct(Long id, Product product) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);

        productEntity.setProductName(product.getProductName());
        productEntity.setDescription(productEntity.getDescription());
        productEntity.setCategories(product.getCategories());
        productEntity.setTags(product.getTags());
        productEntity.setIconUrl(product.getIconUrl());
        productEntity.setPreviewUrl(product.getPreviewUrl());
        productEntity.setImagesUrl(product.getImagesUrl());

        return productRepository.save(productEntity);
    }

    //    ToDo:
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

//    ToDo: add batch request with file or smth else
//    public ProductEntity editProductBatch() {
//        return null;
//    }
}
