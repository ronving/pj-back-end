package com.playjoy.service;

import com.playjoy.domain.ProductEntity;
import com.playjoy.enums.Category;
import com.playjoy.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

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

    //    ToDo:
    public ProductEntity addProduct() {
        return null;
    }

    //    ToDo:
    public ProductEntity editProduct() {
        return null;
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
