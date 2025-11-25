package com.microshop.product.application.services.mapper;

import com.microshop.product.domain.models.Product;
import com.microshop.product.infrastructure.adapters.persistence.entity.ProductEntity;
import com.microshop.product.infrastructure.web.request.CreateProductRequest;
import com.microshop.product.infrastructure.web.request.PatchUpdateProductRequest;
import com.microshop.product.infrastructure.web.request.UpdateProductRequest;
import com.microshop.product.infrastructure.web.response.ProductResponse;
import org.mapstruct.*;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {

    Product toDomain(CreateProductRequest request);

    Product toDomainFromEntity(ProductEntity request);

    ProductResponse toResponseFromDomain(Product product);

    @Mapping(target = "id", source = "id")
    ProductEntity toEntity(Product product);

    @Mapping(target = "id", ignore = true)
    void updateEntity(UpdateProductRequest request, @MappingTarget Product product);

    @Mapping(target = "id", ignore = true) // ID не обновляем
    void updateEntityFromDomain(Product product, @MappingTarget ProductEntity entity);

    @Mapping(target = "id", ignore = true)
    void patchEntity(PatchUpdateProductRequest request, @MappingTarget Product product);

    @Mapping(target = "id", ignore = true)
    void patchUpdateEntityFromDomain(Product request, @MappingTarget ProductEntity product);

    ProductResponse toResponse(Product product);

    @AfterMapping
    default void setDefaultValues(@MappingTarget Product product, CreateProductRequest request) {
        if (product.getCreatedAt() == null) {
            product.setCreatedAt(LocalDateTime.now());
        }
    }
}

