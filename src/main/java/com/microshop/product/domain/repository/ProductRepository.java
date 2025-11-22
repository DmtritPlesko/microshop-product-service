package com.microshop.product.domain.repository;

import com.microshop.product.domain.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Product save(Product product);

    Product updateProduct(Product product);

    Product patchUpdateProduct(Product product);

    Optional<Product> findById(String id);

    List<Product> findAll();

    void deleteById(String id);
}
