package com.ctse.user.persistance.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

  @Id private ObjectId _id;

  private String name;
  private String username;
  private String email;
  private String phoneNumber;
}
