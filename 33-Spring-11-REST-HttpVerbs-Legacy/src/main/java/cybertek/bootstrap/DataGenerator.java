package cybertek.bootstrap;

import cybertek.entity.Product;
import cybertek.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        Product pc = new Product("DELL");
        Product laptop = new Product("MACBOOK");
        Product phone = new Product("IPHONE");
        Product tablet = new Product("IPAD");

        List<Product> productList = Arrays.asList(pc, laptop, phone, tablet);

        productRepository.saveAll(productList);

    }

}
