package com.ctse.user.persistance.repository;

import com.ctse.user.persistance.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {}
