package com.example.AtlAcademy.services;

import com.example.AtlAcademy.models.Product;
import com.example.AtlAcademy.models.TableEntity;
import com.example.AtlAcademy.repositories.ProductRepository;
import com.example.AtlAcademy.repositories.TableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void createProduct(Product product) {
        if (productRepository.existsById(product.getId())) {
            throw new RuntimeException("El producto ya ha sido creado");
        }
        productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }


}
