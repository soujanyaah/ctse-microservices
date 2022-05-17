package com.ctse.order.controller.dto;

import com.ctse.order.persistance.model.Order;
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
public class OrderDto {

    private ObjectId _id;
    private String username;
    private String orderID;
    private Date placedDate;
    private double amount;

    public static OrderDto convertToDto(Order order) {
        OrderDto orderDto =
                OrderDto.builder()
                        ._id(order.get_id())
                        .username(order.getUsername())
                        .orderID(order.getOrderID())
                        .placedDate(order.getPlacedDate())
                        .amount(order.getAmount())
                        .build();
        return orderDto;
    }
}
