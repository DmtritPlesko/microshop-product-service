package com.study.platform.infrastructure.web.controller;

import com.study.platform.application.services.ProductService;
import com.study.platform.infrastructure.web.controller.documentation.CreateProductDock;
import com.study.platform.infrastructure.web.request.CreateProductRequest;
import com.study.platform.infrastructure.web.request.PatchUpdateProductRequest;
import com.study.platform.infrastructure.web.request.UpdateProductRequest;
import com.study.platform.infrastructure.web.response.ProductResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/product")
public class ProductController {

    private ProductService productService;

    @PostMapping(path = "/create")
    @CreateProductDock
    public ResponseEntity<?> createProduct(@RequestBody @Valid CreateProductRequest createProductRequest) {

        ProductResponse productResponse = productService.createProduct(createProductRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateProduct(
            @PathVariable("id") String id,
            @RequestBody @Valid UpdateProductRequest updateProductRequest) {

        ProductResponse productResponse = productService.updateProduct(id, updateProductRequest);

        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<?> patchUpdateProduct(
            @PathVariable("id") String id,
            @RequestBody @Valid PatchUpdateProductRequest patchUpdateProductRequest) {

        ProductResponse productResponse = productService.patchUpdateProduct(id, patchUpdateProductRequest);

        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") String id) {

        ProductResponse productResponse = productService.getProductById(id);

        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<?> getAllProducts() {

        List<ProductResponse> productResponse = productService.findAllProduct();

        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductById(@PathVariable("id") String id) {

        productService.deleteById(id);
    }
}
