package com.study.platform.infrastructure.web.controller.documentation;

import com.study.platform.infrastructure.web.request.CreateProductRequest;
import com.study.platform.infrastructure.web.response.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Operation(
        summary = "Создание нового продукта в системе",
        description = """
                Создает новый продукт в системе для дальнейшего использования пользователями.
                Продукт становится доступен для назначения студентам после успешного создания.
                Доступно только пользователям с ролью ADMIN или TEACHER.
                """,
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "Данные нового продукта",
                content = @Content(
                        schema = @Schema(implementation = CreateProductRequest.class),
                        mediaType = MediaType.APPLICATION_JSON_VALUE
                )
        )
)
@ApiResponses({
        @ApiResponse(
                responseCode = "200",
                description = "Продукт успешно создан",
                content = @Content(
                        schema = @Schema(implementation = ProductResponse.class),
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = @io.swagger.v3.oas.annotations.media.ExampleObject(
                                value = """
                                        {
                                          "id": 1,
                                          "name": "Java Programming Course",
                                          "description": "Комплексный курс по программированию на Java",
                                          "price": 299.99,
                                          "category": "PROGRAMMING",
                                          "createdAt": "2024-01-15T10:30:00Z",
                                          "status": "ACTIVE",
                                          "duration": 90,
                                          "level": "BEGINNER"
                                        }
                                        """
                        )
                )
        ),
        @ApiResponse(
                responseCode = "401",
                description = "Пользователь не авторизован",
                content = @Content(
                        schema = @Schema(implementation = Error.class),
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = @io.swagger.v3.oas.annotations.media.ExampleObject(
                                value = """
                                        {
                                          "timestamp": "2025-11-17T07:11:30.936+00:00",
                                          "status": 401,
                                          "error": "Unauthorized",
                                          "message": "Требуется аутентификация"
                                        }
                                        """
                        )
                )
        ),
        @ApiResponse(
                responseCode = "403",
                description = "Нет прав доступа",
                content = @Content(
                        schema = @Schema(implementation = Error.class),
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = @io.swagger.v3.oas.annotations.media.ExampleObject(
                                value = """
                                        {
                                          "timestamp": "2025-11-17T07:11:30.936+00:00",
                                          "status": 403,
                                          "error": "Forbidden",
                                          "message": "Недостаточно прав для создания продукта"
                                        }
                                        """
                        )
                )
        ),
        @ApiResponse(
                responseCode = "400",
                description = "Некорректные данные продукта",
                content = @Content(
                        schema = @Schema(implementation = Error.class),
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = @io.swagger.v3.oas.annotations.media.ExampleObject(
                                value = """
                                        {
                                          "timestamp": "2025-11-17T07:11:30.936+00:00",
                                          "status": 400,
                                          "error": "ValidationError",
                                          "message": "Название продукта не может быть пустым"
                                        }
                                        """
                        )
                )
        ),
        @ApiResponse(
                responseCode = "409",
                description = "Продукт с таким названием уже существует",
                content = @Content(
                        schema = @Schema(implementation = Error.class),
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = @io.swagger.v3.oas.annotations.media.ExampleObject(
                                value = """
                                        {
                                          "timestamp": "2025-11-17T07:11:30.936+00:00",
                                          "status": 409,
                                          "error": "ProductAlreadyExists",
                                          "message": "Продукт с названием 'Java Programming Course' уже существует"
                                        }
                                        """
                        )
                )
        )
})
public @interface CreateProductDock {
}
