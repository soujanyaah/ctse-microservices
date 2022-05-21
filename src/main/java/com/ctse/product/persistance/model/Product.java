package com.ctse.product.persistance.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {

  @Id private ObjectId _id;

  private String name;
  private String status;
  private String code;
  private double price;
}
