package com.study.platform.infrastructure.config;

import com.study.platform.domain.repository.ProductRepository;
import com.study.platform.infrastructure.adapters.persistence.JpaProductRepositoryAdapter;
import com.study.platform.infrastructure.adapters.persistence.repository.SpringDataProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ProductRepository productRepository(SpringDataProductRepository springDataProductRepository) {

        return new JpaProductRepositoryAdapter(springDataProductRepository);
    }
}
