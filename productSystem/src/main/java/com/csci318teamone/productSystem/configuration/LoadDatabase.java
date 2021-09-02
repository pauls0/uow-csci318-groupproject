package com.csci318teamone.productSystem.configuration;

import com.csci318teamone.productSystem.entities.Product;
import com.csci318teamone.productSystem.entities.ProductDetail;
import com.csci318teamone.productSystem.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(ProductRepository productRepository) {
    return args -> {
      log.info(
        "Preloading " +
        productRepository.save(
          new Product(
            "Fruit",
            "Royal Gala Apple",
            0.62,
            200,
            new ProductDetail(
              "Apples are juicy, crisp and come in a variety of colours including red, pink and green.",
              "Store your apples in the fridge"
            )
          )
        )
      );

      log.info(
        "Preloading " +
        productRepository.save(
          new Product(
            "Fruit",
            "Cavendish Banana",
            0.72,
            200,
            new ProductDetail(
              "Bananas are perfect for snacking, used in baking, fruit salads and smoothies.",
              "Bananas are the worlds oldest fruit!"
            )
          )
        )
      );
    };
  }
}
