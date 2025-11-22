package com.microshop.product.infrastructure.adapters.persistence.repository;

import com.microshop.product.infrastructure.adapters.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataProductRepository extends JpaRepository<ProductEntity, String> {

}
