package com.csci318teamone.customerSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class CustomerSystemApplication {

  public static void main(String[] args) {
    SpringApplication.run(CustomerSystemApplication.class, args);
  }

  @RequestMapping("/")
  String home() {
    return "Hello World";
  }
}
