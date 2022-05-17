package com.ctse.delivery.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageableDto<T> {
  private List<T> data;
  private long totalRecords;
}
