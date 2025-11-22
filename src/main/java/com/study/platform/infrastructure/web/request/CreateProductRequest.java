package com.study.platform.infrastructure.web.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateProductRequest(
        @NotBlank(message = "product name is required")
        @Size(min = 2, max = 100, message = "Название должно лежать в пределах от 2 до 100")
        String name,

        @Size(max = 100, message = "Слишком длинное описание")
        String description,

        @NotBlank(message = "Артикул не может быть пустым")
        @Pattern(regexp = "^[A-Z0-9-]+$", message = "Неверная форма артикула")
        String sku
) {
}
