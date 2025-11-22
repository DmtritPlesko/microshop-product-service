package com.study.platform.application.services.mapper;

import com.study.platform.domain.models.Product;
import com.study.platform.infrastructure.web.request.CreateProductRequest;
import com.study.platform.infrastructure.web.request.PatchUpdateProductRequest;
import com.study.platform.infrastructure.web.request.UpdateProductRequest;
import com.study.platform.infrastructure.web.response.ProductResponse;
import org.mapstruct.*;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {

    Product toDomain(CreateProductRequest request);

    @Mapping(target = "id", ignore = true)
    void updateEntity(UpdateProductRequest request, @MappingTarget Product product);

    @Mapping(target = "id", ignore = true)
    void patchEntity(PatchUpdateProductRequest request, @MappingTarget Product product);

    ProductResponse toResponse(Product product);

    @AfterMapping
    default void setDefaultValues(@MappingTarget Product product, CreateProductRequest request) {
        if (product.getCreatedAt() == null) {
            product.setCreatedAt(LocalDateTime.now());
        }
    }
}

