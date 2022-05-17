package com.ctse.order.controller;

import com.ctse.order.controller.dto.OrderDto;
import com.ctse.order.controller.dto.PageableDto;
import com.ctse.order.persistance.model.Order;
import com.ctse.order.persistance.model.PageableEntityData;
import com.ctse.order.service.OrderService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/order")
public class OrderController {

  @Autowired OrderService orderService;

  @GetMapping()
  public PageableDto<OrderDto> getOrder(
      @PageableDefault()
          @SortDefault.SortDefaults({@SortDefault(sort = "name", direction = Sort.Direction.ASC)})
          Pageable pageable) {
    PageableEntityData<Order> serviceData = orderService.getOrderList(pageable);
    List<OrderDto> orderList =
        serviceData.getData().stream().map(OrderDto::convertToDto).collect(Collectors.toList());

    return new PageableDto<>(orderList, serviceData.getTotalRecords());
  }

  @PostMapping()
  public OrderDto createOrder(@Validated @RequestBody OrderDto orderDto) {
    return orderService.create(orderDto);
  }

  @PutMapping("/{objectId}")
  public OrderDto updateOrder(
      @PathVariable ObjectId objectId, @Validated @RequestBody OrderDto orderDto) {
    return orderService.update(objectId, orderDto);
  }

  @DeleteMapping("/{objectId}")
  public String deleteOrder(@PathVariable ObjectId objectId) {
    return orderService.Delete(objectId);
  }
}
