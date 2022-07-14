package net.liewe.ah.config;

import net.liewe.ah.model.Subscription;
import net.liewe.ah.repository.SubscriptionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SubscriptionConfig {

    @Bean
    CommandLineRunner commandLineRunner2(SubscriptionRepository repository){
        return args -> {
            Subscription sub_melk = new Subscription(
                    "liewe@", "melk", 1.2, "1Li", "discounted", "www.imageurl");
            //repository.saveAll(List.of(sub_melk));
        };
    }
}
