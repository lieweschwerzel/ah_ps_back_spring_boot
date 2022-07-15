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
            Product ahKomkommer = new Product(
                    "AH Komkommer", 0.55, "300gr", "discounted",
                    "https://static.ah.nl/dam/product/AHI_434d50313535333334?revLabel=2&rendition=200x200_JPG_Q85&fileType=binary","nog een www" );
//                    "melk", 0.55, "1L", "discounted", "www.imageurl"
//            Product melk = new Product(
//            );
          //  repository.saveAll(List.of(ahKomkommer));
        };
    }
}
