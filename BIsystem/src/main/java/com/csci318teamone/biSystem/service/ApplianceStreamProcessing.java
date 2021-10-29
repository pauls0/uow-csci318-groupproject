package com.csci318teamone.biSystem.service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.csci318teamone.biSystem.model.Equipment;
import com.csci318teamone.biSystem.model.ProductQuantity;
import com.csci318teamone.biSystem.model.PurchaseMessage;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Printed;
import org.apache.kafka.streams.state.KeyValueStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerde;

@Configuration
public class ApplianceStreamProcessing {

  public static final String PRODUCT_STATE_STORE = "product-store";
  public static final String EQUIPMENT_STATE_STORE = "equipment-store";

  @Bean
  public Function<KStream<?, PurchaseMessage>, KStream<String, ProductQuantity>> process() {
    return inputStream -> {
      inputStream
        .map(
          (k, v) -> {
            String equipment_name = v.getEquipment();
            String product_name = v.getProduct();
            Equipment equipment = new Equipment();
            equipment.setEquipment(equipment_name);
            equipment.setProduct(product_name);
            String new_key = product_name + equipment_name;
            return KeyValue.pair(new_key, equipment);
          }
        )
        .toTable(
          Materialized
            .<String, Equipment, KeyValueStore<Bytes, byte[]>>as(
              EQUIPMENT_STATE_STORE
            )
            .withKeySerde(Serdes.String())
            .withValueSerde(equipmentSerde())
        );

      KTable<String, Long> productKTable = inputStream
        .mapValues(PurchaseMessage::getProduct)
        .groupBy((keyIgnored, value) -> value)
        .count(
          Materialized
            .<String, Long, KeyValueStore<Bytes, byte[]>>as(PRODUCT_STATE_STORE)
            .withKeySerde(Serdes.String())
            .withValueSerde(Serdes.Long())
        );

      KStream<String, ProductQuantity> productQuantityStream = productKTable
        .toStream()
        .map((k, v) -> KeyValue.pair(k, new ProductQuantity(k, v)));
      productQuantityStream.print(
        Printed.<String, ProductQuantity>toSysOut().withLabel("Console Output")
      );

      return productQuantityStream;
    };
  }

  public Serde<Equipment> equipmentSerde() {
    final JsonSerde<Equipment> equipmentJsonSerde = new JsonSerde<>();
    Map<String, Object> configProps = new HashMap<>();
    configProps.put(
      JsonDeserializer.VALUE_DEFAULT_TYPE,
      "com.csci318teamone.biSystem.model.Equipment"
    );
    configProps.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
    equipmentJsonSerde.configure(configProps, false);
    return equipmentJsonSerde;
  }
}
