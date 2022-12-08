package com.cybertek.controller;

import com.cybertek.annotation.ExecutionTime;
import com.cybertek.entity.Product;
import com.cybertek.entity.ResponseWrapper;
import com.cybertek.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

//    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        return ResponseEntity
                .ok(productService.getProduct(id));
    }

    @ExecutionTime
    @GetMapping()
    public ResponseEntity<List<Product>> getProducts() {
//        logger.info("Before -> Controller:{} - Method:{} - Input Parameter:{}", "ProductController", "getProducts()");

        List<Product> list = productService.getProducts();

//        logger.info("After -> Controller:{} - Method:{} - Output Parameter:{}", "ProductController", "getProducts()", list);

        return ResponseEntity
                .ok(list);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Product>> deleteProduct(@PathVariable("id") Long id) {
        return ResponseEntity
                .ok(productService.delete(id));
    }

    @PostMapping()
    public List<Product> createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<List<Product>> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        List<Product> list = productService.updateProduct(id, product);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

        map.add("Version", "Cybertek.v1");
        map.add("Operation", "Update Product");

        return new ResponseEntity<>(list, map, HttpStatus.OK);
    }

    @GetMapping("/read")
    public ResponseEntity<ResponseWrapper> readAllProducts() {
        return ResponseEntity
                .ok(new ResponseWrapper("Products successfully retrieved", productService.getProducts()));
    }

    @DeleteMapping("/delete1/{id}")
    public ResponseEntity<ResponseWrapper> delete1(@PathVariable Long id) {
        return ResponseEntity
                .ok(new ResponseWrapper("Product successfully deleted"));
    }

    @DeleteMapping("/delete2/{id}")
    public ResponseEntity<ResponseWrapper> delete2(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseWrapper("Product successfully deleted"));
    }

}
