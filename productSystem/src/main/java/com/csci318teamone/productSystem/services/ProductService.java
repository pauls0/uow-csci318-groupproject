package com.csci318teamone.productSystem.services;

import com.csci318teamone.productSystem.entities.Product;
import java.util.List;

public interface ProductService {
  List<Product> getProducts();

  Product getProductById(Long id);

  Product createProduct(Product Product);

  Product updateProductById(Long id, Product newProduct);

  void deleteProductById(Long id);
}
