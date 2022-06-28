package com.cybertek.controller;

import com.cybertek.entity.Product;
import com.cybertek.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") Long id) {
        return productService.getProduct(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public List<Product> deleteProduct(@PathVariable("id") Long id) {
        return productService.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<Product> createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public List<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

}
