package com.ctse.order.service;

import com.ctse.order.controller.dto.OrderDto;
import com.ctse.order.controller.exception.handel.NoContentException;
import com.ctse.order.persistance.model.Order;
import com.ctse.order.persistance.model.PageableEntityData;
import com.ctse.order.persistance.repository.OrderRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
  @Autowired private OrderRepository orderRepository;

  public PageableEntityData<Order> getOrderList(Pageable pageable) {
    Page<Order> OrderList = orderRepository.findAll(pageable);
    if (OrderList.getContent().isEmpty()) throw new NoContentException();
    return new PageableEntityData<>(OrderList.getContent(), OrderList.getTotalElements());
  }

  public OrderDto create(OrderDto orderDto) {
    Order order = new Order();
    order.setUsername(orderDto.getUsername());
    order.setOrderID(orderDto.getOrderID());
    order.setPlacedDate(orderDto.getPlacedDate());
    order.setAmount(orderDto.getAmount());
    orderRepository.save(order);
    return orderDto;
  }

  public OrderDto update(ObjectId id, OrderDto orderDto) {
    Order order = orderRepository.findById(id).get();
    order.setUsername(orderDto.getUsername());
    order.setOrderID(orderDto.getOrderID());
    order.setPlacedDate(orderDto.getPlacedDate());
    order.setAmount(orderDto.getAmount());
    orderRepository.save(order);
    return orderDto;
  }

  public String Delete(ObjectId id) {
    orderRepository.deleteById(id);
    return "Order Deleted";
  }
}
