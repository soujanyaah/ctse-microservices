package com.ctse.product.controller.dto;

import com.ctse.product.persistance.model.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {

    private ObjectId _id;
    private String name;
    private String status;
    private String code;
    private double price;

    public static ProductDto convertToDto(Product product) {
        ProductDto productDto =
                ProductDto.builder()
                        ._id(product.get_id())
                        .name(product.getName())
                        .status(product.getStatus())
                        .code(product.getCode())
                        .price(product.getPrice())
                        .build();
        return productDto;
    }
}
