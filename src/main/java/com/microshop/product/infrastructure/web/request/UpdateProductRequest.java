package com.microshop.product.infrastructure.web.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record UpdateProductRequest(
        @NotBlank(message = "Название продукта обязательно")
        @Size(min = 2, max = 100, message = "Название должно быть от 2 до 100 символов")
        String name,

        @Size(max = 500, message = "Описание слишком длинное")
        String description,

        @NotBlank(message = "Артикул обязателен")
        @Pattern(regexp = "^[A-Z0-9-]+$", message = "Неверная форма артикула")
        String sku,

        @NotNull(message = "Цена обязательна")
        @DecimalMin(value = "0.0", inclusive = false, message = "Цена должна быть положительной")
        @Digits(integer = 10, fraction = 2, message = "Некорректный формат цены")
        BigDecimal price,

        @NotBlank(message = "Бренд обязателен")
        String brand,

        String model,

        @NotNull(message = "Дата создания обязательна")
        @PastOrPresent(message = "Дата создания не может быть в будущем")
        LocalDateTime createdAt,

        boolean availability
) {
}
