package com.csci318teamone.biSystem.service;

import java.util.NoSuchElementException;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;
import org.springframework.stereotype.Service;

@Service
public class ProductInteractiveQuery {

  private final InteractiveQueryService interactiveQueryService;

  public ProductInteractiveQuery(
    InteractiveQueryService interactiveQueryService
  ) {
    this.interactiveQueryService = interactiveQueryService;
  }

  // usecase 10 - gives total order qualtity for a product
  public long getProductQuantity(String productName) {
    if (productStore().get(productName) != null) {
      return productStore().get(productName);
    } else {
      throw new NoSuchElementException();
    }
  }

  private ReadOnlyKeyValueStore<String, Long> productStore() {
    return this.interactiveQueryService.getQueryableStore(
        ApplianceStreamProcessing.PRODUCT_STATE_STORE,
        QueryableStoreTypes.keyValueStore()
      );
  }
}
