package com.ctse.delivery.controller;

import com.ctse.delivery.controller.dto.DeliveryDto;
import com.ctse.delivery.controller.dto.PageableDto;
import com.ctse.delivery.persistance.model.Delivery;
import com.ctse.delivery.persistance.model.PageableEntityData;
import com.ctse.delivery.service.DeliveryService;
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
@RequestMapping("/api/delivery")
public class DeliveryController {

  @Autowired DeliveryService deliveryService;

  @GetMapping()
  public PageableDto<DeliveryDto> getDelivery(
      @PageableDefault()
          @SortDefault.SortDefaults({@SortDefault(sort = "name", direction = Sort.Direction.ASC)})
          Pageable pageable) {
    PageableEntityData<Delivery> serviceData = deliveryService.getDeliveryList(pageable);
    List<DeliveryDto> deliveryList =
        serviceData.getData().stream().map(DeliveryDto::convertToDto).collect(Collectors.toList());

    return new PageableDto<>(deliveryList, serviceData.getTotalRecords());
  }

  @PostMapping()
  public DeliveryDto createDelivery(@Validated @RequestBody DeliveryDto deliveryDto) {
    return deliveryService.create(deliveryDto);
  }

  @PutMapping("/{objectId}")
  public DeliveryDto updateDelivery(
      @PathVariable ObjectId objectId, @Validated @RequestBody DeliveryDto deliveryDto) {
    return deliveryService.update(objectId, deliveryDto);
  }

  @DeleteMapping("/{objectId}")
  public String deleteDelivery(@PathVariable ObjectId objectId) {
    return deliveryService.Delete(objectId);
  }
}
