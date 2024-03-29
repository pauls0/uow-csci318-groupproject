package com.csci318teamone.purchaseSystem.configuration;

import com.csci318teamone.purchaseSystem.entities.Contact;
import com.csci318teamone.purchaseSystem.entities.Customer;
import com.csci318teamone.purchaseSystem.entities.Product;
import com.csci318teamone.purchaseSystem.entities.ProductDetail;
import com.csci318teamone.purchaseSystem.entities.Purchase;
import com.csci318teamone.purchaseSystem.services.PurchaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
  // @Bean
  // public CommandLineRunner run(PurchaseService purchaseService)
  //   throws Exception {
  //   return args -> {
  //     log.info(
  //       "Preloading " +
  //       purchaseService.recordPurchase(
  //         new Purchase(
  //           null,
  //           1,
  //           new Product(
  //             "Fruit",
  //             "Royal Gala Apple",
  //             0.62,
  //             200,
  //             new ProductDetail(
  //               "Apples are juicy",
  //               "Store your apples in the fridge"
  //             )
  //           ),
  //           new Customer(
  //             "Apple",
  //             "1 Apple Park Way, Cupertino, CA 95014",
  //             "USA",
  //             new Contact("Tim Apple", "123456", "tim@apple.com", "CEO")
  //           )
  //         )
  //       )
  //     );
  //   };
  // }
}
