package com.ctse.delivery.persistance.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
@Document("Deliveries")
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {

  @Id private ObjectId _id;

  private String location;
  private Date estimatedDate;
  private String paymentType;
  private double amount;
}
