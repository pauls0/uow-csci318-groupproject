package com.csci318teamone.productSystem.services;

import com.csci318teamone.productSystem.entities.Product;
import com.csci318teamone.productSystem.exception.ProductNotFoundException;
import com.csci318teamone.productSystem.repositories.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  private ProductRepository productRepository;

  @Autowired
  public void setProductRepository(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> getProducts() {
    return productRepository.findAll();
  }

  public Product getProductById(Long id) {
    return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
  }

  public Product createProduct(Product product) {
    return productRepository.save(product);
  }

  public Product updateProductById(Long id, Product newProduct) {
    return productRepository
      .findById(id)
      .map(
        product -> {
          product.setName(newProduct.getName());
          product.setProductCategory(newProduct.getProductCategory());
          product.setPrice(newProduct.getPrice());
          product.setStockQuantity(newProduct.getStockQuantity());
          product.setProductDetail(newProduct.getProductDetail());
          return productRepository.save(product);
        }
      )
      .orElseGet(
        () -> {
          newProduct.setId(id);
          return productRepository.save(newProduct);
        }
      );
  }

  public void deleteProductById(Long id) {
    productRepository.deleteById(id);
  }
}
