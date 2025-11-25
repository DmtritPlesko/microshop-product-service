package com.microshop.product.infrastructure.adapters.persistence;

import com.microshop.product.application.services.mapper.ProductMapper;
import com.microshop.product.domain.exception.ProductNotFoundException;
import com.microshop.product.domain.models.Product;
import com.microshop.product.domain.repository.ProductRepository;
import com.microshop.product.infrastructure.adapters.persistence.entity.ProductEntity;
import com.microshop.product.infrastructure.adapters.persistence.repository.SpringDataProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class JpaProductRepositoryAdapter implements ProductRepository {

    SpringDataProductRepository springDataProductRepository;
    ProductMapper mapper;

    public JpaProductRepositoryAdapter(SpringDataProductRepository springDataProductRepository) {
        this.springDataProductRepository = springDataProductRepository;
    }

    @Override
    @Transactional
    public Product save(Product product) {

        return mapper.toDomainFromEntity(
                springDataProductRepository.save(mapper.toEntity(product))
        );
    }

    @Override
    @Transactional
    public Product updateProduct(String id, Product product) {

        ProductEntity existingProductEntity = springDataProductRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found by id"));

        mapper.updateEntityFromDomain(product, existingProductEntity);

        return mapper.toDomainFromEntity(existingProductEntity);
    }

    @Override
    @Transactional
    public Product patchUpdateProduct(String id, Product product) {

        ProductEntity existProductEntity = springDataProductRepository.findById(product.getId())
                .orElseThrow(() -> new ProductNotFoundException("Product not found by id"));

        mapper.patchUpdateEntityFromDomain(product, existProductEntity);

        return mapper.toDomainFromEntity(existProductEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(String id) {

        ProductEntity existsProductEntity = springDataProductRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found by id"));

        return mapper.toDomainFromEntity(existsProductEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {

        return springDataProductRepository.findAll().stream()
                .map(mapper::toDomainFromEntity)
                .toList();
    }

    @Override
    @Transactional
    public void deleteById(String id) {

        if (!springDataProductRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }

        springDataProductRepository.deleteById(id);

    }
}
