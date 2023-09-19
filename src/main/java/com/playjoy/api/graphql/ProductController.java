package com.playjoy.api.graphql;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.playjoy.api.types.Product;
import com.playjoy.api.types.ProductInput;
import com.playjoy.enums.Category;
import com.playjoy.service.ProductService;
import lombok.RequiredArgsConstructor;

@DgsComponent
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    //ToDo: add mapstruct dependencies and mapper interface, map entities to dtos
    @DgsQuery
    public Product findProduct(@InputArgument Long id) {
//        return productService.findProduct(id);
        return null;
    }

    @DgsQuery
    public Product findAllProducts() {
        return null;
    }

    @DgsQuery
    public Product findProductsByCategory(@InputArgument Category category, int page, int size) {
        return null;
    }

    @DgsMutation
    public Product addProduct(@InputArgument ProductInput product) {
        return null;
    }

    @DgsMutation
    public Product updateProduct(@InputArgument ProductInput product) {
        return null;
    }

    @DgsMutation
    public Product deleteProduct(@InputArgument Long id) {
        return null;
    }
}
