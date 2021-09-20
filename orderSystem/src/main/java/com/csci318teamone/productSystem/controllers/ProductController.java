package com.csci318teamone.productSystem.controllers;

import com.csci318teamone.productSystem.entities.Product;
import com.csci318teamone.productSystem.services.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

  private ProductService productService;

  @Autowired
  public void setProductRepository(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  List<Product> getProducts() {
    return productService.getProducts();
  }

  @PostMapping
  Product createProduct(@RequestBody Product newProduct) {
    return productService.createProduct(newProduct);
  }

  @GetMapping("{id}")
  Product getProductById(@PathVariable Long id) {
    return productService.getProductById(id);
  }

  @PutMapping("{id}")
  Product updateProductById(@PathVariable Long id, @RequestBody Product newProduct) {
    return productService.updateProductById(id, newProduct);
  }

  @DeleteMapping("{id}")
  void deleteProductById(@PathVariable Long id) {
    productService.deleteProductById(id);
  }
}
