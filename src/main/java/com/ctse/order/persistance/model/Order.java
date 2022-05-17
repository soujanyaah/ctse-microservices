package com.ctse.order.persistance.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document("Orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {

  @Id
  private ObjectId _id;

  private String username;
  private String orderID;
  private Date placedDate;
  private double amount;
}
