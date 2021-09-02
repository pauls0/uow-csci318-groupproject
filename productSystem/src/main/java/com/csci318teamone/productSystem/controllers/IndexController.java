package com.csci318teamone.productSystem.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

  @RequestMapping("/")
  String home() {
    return "Hello World";
  }
}
