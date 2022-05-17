package com.ctse.product.controller;

import com.ctse.product.controller.dto.PageableDto;
import com.ctse.product.controller.dto.ProductDto;
import com.ctse.product.persistance.model.PageableEntityData;
import com.ctse.product.persistance.model.Product;
import com.ctse.product.service.ProductService;
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
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping()
    public PageableDto<ProductDto> getProduct(
            @PageableDefault()
            @SortDefault.SortDefaults({@SortDefault(sort = "name", direction = Sort.Direction.ASC)})
                    Pageable pageable) {
        PageableEntityData<Product> serviceData = productService.getProductList(pageable);
        List<ProductDto> productList =
                serviceData.getData().stream().map(ProductDto::convertToDto).collect(Collectors.toList());

        return new PageableDto<>(productList, serviceData.getTotalRecords());
    }

    @PostMapping()
    public ProductDto createProduct(@Validated @RequestBody ProductDto productDto) {
        return productService.create(productDto);
    }

    @PutMapping("/{objectId}")
    public ProductDto updateProduct(
            @PathVariable ObjectId objectId, @Validated @RequestBody ProductDto productDto) {
        return productService.update(objectId, productDto);
    }

    @DeleteMapping("/{objectId}")
    public String deleteProduct(@PathVariable ObjectId objectId) {
        return productService.Delete(objectId);
    }
}
