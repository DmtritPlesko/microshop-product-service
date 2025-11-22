package com.study.platform.infrastructure.web.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PatchUpdateProductRequest(
        String name,
        String description,
        String sku,
        BigDecimal price,
        String brand,
        String model,
        LocalDateTime createdAt,
        boolean availability
) {
}
