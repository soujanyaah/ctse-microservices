package com.ctse.product.persistance.repository;
import com.ctse.product.persistance.model.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, ObjectId>{
}
