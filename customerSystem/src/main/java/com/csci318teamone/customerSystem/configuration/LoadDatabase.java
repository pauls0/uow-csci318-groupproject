package com.csci318teamone.customerSystem.configuration;

import com.csci318teamone.customerSystem.entities.Contact;
import com.csci318teamone.customerSystem.entities.Customer;
import com.csci318teamone.customerSystem.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CustomerRepository customerRepository) {
        return args -> {
            log.info("Preloading " + customerRepository.save(
                    new Customer(
                        "Apple",
                        "1 Apple Park Way, Cupertino, CA 95014",
                        "USA",
                        new Contact(
                            "Tim Apple",
                            "123456",
                            "tim@apple.com",
                            "CEO"
                        )
                    )
                )
            );

            log.info("Preloading " + customerRepository.save(
                    new Customer(
                        "SpaceX",
                        "42 Galactic Drive, San Francisco, CA 97468",
                        "USA",
                        new Contact(
                            "Elon Musk",
                            "69420",
                            "elon@spacex.com",
                            "CEO"
                        )
                    )
                )
            );
        };
    }
}