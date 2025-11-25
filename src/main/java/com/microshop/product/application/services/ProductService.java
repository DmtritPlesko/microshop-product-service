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

@Service
public class ProductService {

    private ProductRepository productRepository;
    private ProductMapper mapper;

    public ProductResponse createProduct(CreateProductRequest createProductRequest) {

        return mapper.toResponseFromDomain(
                productRepository.save(mapper.toDomain(createProductRequest))
        );
    }

    public ProductResponse updateProduct(String id,
                                         UpdateProductRequest updateProductRequest) {

        Product product = new Product();

        mapper.updateEntity(updateProductRequest, product);

        return mapper.toResponseFromDomain(
                productRepository.updateProduct(id, product)
        );
    }

    public ProductResponse patchUpdateProduct(String id,
                                              PatchUpdateProductRequest patchUpdateProductRequest) {

        Product product = new Product();

        mapper.patchEntity(patchUpdateProductRequest, product);

        return mapper.toResponseFromDomain(
                productRepository.patchUpdateProduct(id, product)
        );
    }

    public ProductResponse getProductById(String id) {

        return mapper.toResponseFromDomain(
                productRepository.findById(id)
        );
    }

    public List<ProductResponse> findAllProduct() {

        return productRepository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    public void deleteById(String id) {

        productRepository.deleteById(id);
    }

}
