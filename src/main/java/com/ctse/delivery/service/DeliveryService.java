package com.ctse.delivery.service;

import com.ctse.delivery.controller.dto.DeliveryDto;
import com.ctse.delivery.controller.exception.handel.NoContentException;
import com.ctse.delivery.persistance.model.Delivery;
import com.ctse.delivery.persistance.model.PageableEntityData;
import com.ctse.delivery.persistance.repository.DeliveryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
  @Autowired private DeliveryRepository deliveryRepository;

  public PageableEntityData<Delivery> getDeliveryList(Pageable pageable) {
    Page<Delivery> DeliveryList = deliveryRepository.findAll(pageable);
    if (DeliveryList.getContent().isEmpty()) throw new NoContentException();
    return new PageableEntityData<>(DeliveryList.getContent(), DeliveryList.getTotalElements());
  }

  public DeliveryDto create(DeliveryDto deliveryDto) {
    Delivery delivery = new Delivery();
    delivery.setLocation(deliveryDto.getLocation());
    delivery.setEstimatedDate(deliveryDto.getEstimatedDate());
    delivery.setPaymentType(deliveryDto.getPaymentType());
    delivery.setAmount(deliveryDto.getAmount());
    deliveryRepository.save(delivery);
    return deliveryDto;
  }

  public DeliveryDto update(ObjectId id, DeliveryDto deliveryDto) {
    Delivery delivery = deliveryRepository.findById(id).get();
    delivery.setLocation(deliveryDto.getLocation());
    delivery.setEstimatedDate(deliveryDto.getEstimatedDate());
    delivery.setPaymentType(deliveryDto.getPaymentType());
    delivery.setAmount(deliveryDto.getAmount());
    deliveryRepository.save(delivery);
    return deliveryDto;
  }

  public String Delete(ObjectId id) {
    deliveryRepository.deleteById(id);
    return "Product Deleted";
  }
}
