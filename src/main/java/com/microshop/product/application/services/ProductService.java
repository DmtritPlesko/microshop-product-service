package com.microshop.product.application.services;

import com.microshop.product.application.services.mapper.ProductMapper;
import com.microshop.product.domain.models.Product;
import com.microshop.product.domain.repository.ProductRepository;
import com.microshop.product.infrastructure.web.request.CreateProductRequest;
import com.microshop.product.infrastructure.web.request.PatchUpdateProductRequest;
import com.microshop.product.infrastructure.web.request.UpdateProductRequest;
import com.microshop.product.infrastructure.web.response.ProductResponse;
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
