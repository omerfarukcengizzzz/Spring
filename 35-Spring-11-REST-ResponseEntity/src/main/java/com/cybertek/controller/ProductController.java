package com.cybertek.controller;

import com.cybertek.entity.Product;
import com.cybertek.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        return ResponseEntity
                .ok(productService.getProduct(id));
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getProducts() {
        HttpHeaders responseHttpHeaders = new HttpHeaders();

        responseHttpHeaders.set("Version", "Cybertek.v1");
        responseHttpHeaders.set("Operation", "Get List");

        return ResponseEntity
                .ok()
                .headers(responseHttpHeaders)
                .body(productService.getProducts());
    }

    @DeleteMapping("/{id}")
    public List<Product> deleteProduct(@PathVariable("id") Long id) {
        return productService.delete(id);
    }

    @PostMapping()
    public ResponseEntity<List<Product>> createProduct(@RequestBody Product product) {
        List<Product> set = productService.createProduct(product);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Version", "Cybertek.v1")
                .header("Operation", "Create Product")
                .body(set);
    }

    @PutMapping("/{id}")
    public List<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

}
