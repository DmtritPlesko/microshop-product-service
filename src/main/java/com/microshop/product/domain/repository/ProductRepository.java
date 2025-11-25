package com.microshop.product.domain.repository;

import com.microshop.product.domain.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Product save(Product product);

    Product updateProduct(String id,Product product);

    Product patchUpdateProduct(String id,Product product);

    Product findById(String id);

    List<Product> findAll();

    void deleteById(String id);
}
