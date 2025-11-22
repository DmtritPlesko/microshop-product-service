package com.study.platform.application.services;

import com.study.platform.application.services.mapper.ProductMapper;
import com.study.platform.domain.models.Product;
import com.study.platform.domain.repository.ProductRepository;
import com.study.platform.infrastructure.web.request.CreateProductRequest;
import com.study.platform.infrastructure.web.request.PatchUpdateProductRequest;
import com.study.platform.infrastructure.web.request.UpdateProductRequest;
import com.study.platform.infrastructure.web.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private ProductMapper mapper;

    public ProductResponse createProduct(CreateProductRequest createProductRequest) {

        return mapper.toResponse(mapper.toDomain(createProductRequest));
    }

    public ProductResponse updateProduct(String id, UpdateProductRequest updateProductRequest) {

        Product product = validateById(id);

        mapper.updateEntity(updateProductRequest, product);

        return mapper.toResponse(product);
    }

    public ProductResponse patchUpdateProduct(String id, PatchUpdateProductRequest patchUpdateProductRequest) {

        Product product = validateById(id);

        mapper.patchEntity(patchUpdateProductRequest, product);

        return mapper.toResponse(product);
    }

    public ProductResponse getProductById(String id) {

        Product product = validateById(id);

        return mapper.toResponse(product);
    }

    public List<ProductResponse> findAllProduct() {

        return productRepository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    public void deleteById(String id) {

        productRepository.deleteById(id);
    }

    private Product validateById(String id) {

        Optional<Product> product = Optional.ofNullable(productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Продукт с таким айди не существует")));

        return product.get();
    }
}
