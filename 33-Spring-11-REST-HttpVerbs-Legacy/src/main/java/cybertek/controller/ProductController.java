package cybertek.controller;

import cybertek.entity.Product;
import cybertek.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public @ResponseBody Product getProduct(@PathVariable("id") Long id) {
        return productService.getProduct(id);
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public @ResponseBody List<Product> getProducts() {
        return productService.getProducts();
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public @ResponseBody List<Product> deleteProduct(@PathVariable("id") Long id) {
        return productService.delete(id);
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public @ResponseBody List<Product> createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public @ResponseBody List<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

}
