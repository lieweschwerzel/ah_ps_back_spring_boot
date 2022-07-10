package net.liewe.ah.config;

import net.liewe.ah.model.Product;
import net.liewe.ah.model.Subscription;
import net.liewe.ah.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository){
        return args -> {
            Product dropje = new Product(
                    "dropjes", 2.55, "300gr", "discounted", "www.imageurl"
            );
            Product melk = new Product(
                    "melk", 0.55, "1L", "discounted", "www.imageurl"
            );
            //repository.saveAll(List.of(dropje, melk));
        };
    }
}
