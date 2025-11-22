package com.study.platform.infrastructure.adapters.persistence.repository;

import com.study.platform.infrastructure.adapters.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataProductRepository extends JpaRepository<ProductEntity, String> {

}
