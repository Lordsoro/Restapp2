package com.example.AtlAcademy.controllers;

import com.example.AtlAcademy.models.Product;
import com.example.AtlAcademy.models.TableEntity;
import com.example.AtlAcademy.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public List<Product> getproducts(@RequestHeader(value = "Authorization") String token) {
        return productService.getProducts();
    }

    @PostMapping
    public void createTable(@RequestBody Product product) {
        productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteTable(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
