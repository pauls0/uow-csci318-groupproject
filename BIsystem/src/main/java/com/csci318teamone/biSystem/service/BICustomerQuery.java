package com.csci318teamone.biSystem.service;

import com.csci318teamone.biSystem.model.PurchaseMessage;
import java.util.*;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;
import org.springframework.stereotype.Service;

@Service
public class BICustomerQuery {

  public static final String PURCHASE_STATE_STORE = "orderevent-outbound";

  private final InteractiveQueryService interactiveQueryService;

  @Autowired
  public BICustomerQuery(InteractiveQueryService interactiveQueryService) {
    this.interactiveQueryService = interactiveQueryService;
  }

  public List<String> getProducts(String customerId) {
    Set<String> productSet = new HashSet<>();

    KeyValueIterator<String, PurchaseMessage> all = purchaseStore().all();
    while (all.hasNext()) {
      PurchaseMessage purchaseMessage = all.next().value;

      if (customerId.equals(purchaseMessage.getCustomer())) productSet.add(
        purchaseMessage.getProduct()
      );
    }

    return new ArrayList<>(productSet);
  }

  public long getTotalOrdersValue(String customerId) {
    long value = 0;

    KeyValueIterator<String, PurchaseMessage> all = purchaseStore().all();
    while (all.hasNext()) {
      PurchaseMessage purchaseMessage = all.next().value;

      // TODO: Multiply by quantity
      if (customerId.equals(purchaseMessage.getCustomer())) value +=
        Integer.parseInt(purchaseMessage.getTotal());
    }

    return value;
  }

  private ReadOnlyKeyValueStore<String, PurchaseMessage> purchaseStore() {
    return this.interactiveQueryService.getQueryableStore(
        PURCHASE_STATE_STORE,
        QueryableStoreTypes.keyValueStore()
      );
  }
}
