package com.ctse.product.service;

import com.ctse.product.controller.dto.ProductDto;
import com.ctse.product.controller.exception.handel.NoContentException;
import com.ctse.product.persistance.model.PageableEntityData;
import com.ctse.product.persistance.model.Product;
import com.ctse.product.persistance.repository.ProductRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
  @Autowired private ProductRepository productRepository;

  public PageableEntityData<Product> getProductList(Pageable pageable) {
    Page<Product> ProductList = productRepository.findAll(pageable);
    if (ProductList.getContent().isEmpty()) throw new NoContentException();
    return new PageableEntityData<>(ProductList.getContent(), ProductList.getTotalElements());
  }

  public ProductDto create(ProductDto productDto) {
    Product product = new Product();
    product.setName(productDto.getName());
    product.setStatus(productDto.getStatus());
    product.setCode(productDto.getCode());
    product.setPrice(productDto.getPrice());
    productRepository.save(product);
    return productDto;
  }

  public ProductDto update(ObjectId id, ProductDto productDto) {
    Product product = productRepository.findById(id).get();
    product.setName(productDto.getName());
    product.setStatus(productDto.getStatus());
    product.setCode(productDto.getCode());
    product.setPrice(productDto.getPrice());
    productRepository.save(product);
    return productDto;
  }

  public String Delete(ObjectId id) {
    productRepository.deleteById(id);
    return "Product Deleted";
  }
}
