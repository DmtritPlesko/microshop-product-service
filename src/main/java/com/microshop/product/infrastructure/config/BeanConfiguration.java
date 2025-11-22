package com.microshop.product.infrastructure.config;

import com.microshop.product.domain.repository.ProductRepository;
import com.microshop.product.infrastructure.adapters.persistence.JpaProductRepositoryAdapter;
import com.microshop.product.infrastructure.adapters.persistence.repository.SpringDataProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ProductRepository productRepository(SpringDataProductRepository springDataProductRepository) {

        return new JpaProductRepositoryAdapter(springDataProductRepository);
    }
}
