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
            new ProductDetail("Apples are juicy", "Store your apples in the fridge")
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
            new ProductDetail("Perfect for snacking", "The worlds oldest fruit!")
          )
        )
      );

      log.info(
        "Preloading " +
        productRepository.save(
          new Product(
            "Fruit",
            "Packham Pear",
            0.67,
            200,
            new ProductDetail("Crispy white juicy sweet flesh", "Seasonality: March - December")
          )
        )
      );

      log.info(
        "Preloading " +
        productRepository.save(
          new Product(
            "Fruit",
            "Navel Orange",
            0.64,
            200,
            new ProductDetail("the fruit of citrus species in the family Rutaceae", "2 week selflife")
          )
        )
      );

      log.info(
        "Preloading " +
        productRepository.save(
          new Product(
            "Fruit",
            "Avocado",
            1.0,
            200,
            new ProductDetail("a large berry containing a large seed", "around 73% water")
          )
        )
      );
    };
  }
}
