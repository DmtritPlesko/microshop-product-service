package com.microshop.product.infrastructure.adapters.persistence;

import com.microshop.product.domain.models.Product;
import com.microshop.product.domain.repository.ProductRepository;
import com.microshop.product.infrastructure.adapters.persistence.repository.SpringDataProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class JpaProductRepositoryAdapter implements ProductRepository {

    SpringDataProductRepository springDataProductRepository;

    public JpaProductRepositoryAdapter(SpringDataProductRepository springDataProductRepository) {
        this.springDataProductRepository = springDataProductRepository;
    }

    @Override
    @Transactional
    public Product save(Product product) {

        return null;
    }

    @Override
    @Transactional
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    @Transactional
    public Product patchUpdateProduct(Product product) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(String id) {
        return Optional.empty();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    @Transactional
    public void deleteById(String id) {

    }
}
