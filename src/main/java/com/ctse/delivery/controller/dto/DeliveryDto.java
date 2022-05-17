package com.ctse.delivery.controller.dto;

import com.ctse.delivery.persistance.model.Delivery;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.bson.types.ObjectId;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeliveryDto {

  private ObjectId _id;
  private String location;
  private Date estimatedDate;
  private String paymentType;
  private double amount;

  public static DeliveryDto convertToDto(Delivery delivery) {
    DeliveryDto deliveryDto =
        DeliveryDto.builder()
            ._id(delivery.get_id())
            .location(delivery.getLocation())
            .estimatedDate(delivery.getEstimatedDate())
            .paymentType(delivery.getPaymentType())
            .amount(delivery.getAmount())
            .build();
    return deliveryDto;
  }
}
