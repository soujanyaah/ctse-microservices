package com.ctse.user.service;

import com.ctse.user.controller.dto.UserDto;
import com.ctse.user.controller.exception.handel.NoContentException;
import com.ctse.user.persistance.model.PageableEntityData;
import com.ctse.user.persistance.model.User;
import com.ctse.user.persistance.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired private UserRepository userRepository;

  public PageableEntityData<User> getUserList(Pageable pageable) {
    Page<User> UserList = userRepository.findAll(pageable);
    if (UserList.getContent().isEmpty()) throw new NoContentException();
    return new PageableEntityData<>(UserList.getContent(), UserList.getTotalElements());
  }

  public UserDto create(UserDto userDto) {
    User user = new User();
    user.setName(userDto.getName());
    user.setUsername(userDto.getUsername());
    user.setEmail(userDto.getEmail());
    user.setPhoneNumber(userDto.getPhoneNumber());
    userRepository.save(user);
    return userDto;
  }

  public UserDto update(ObjectId id, UserDto userDto) {
    User user = userRepository.findById(id).get();
    user.setName(userDto.getName());
    user.setUsername(userDto.getUsername());
    user.setEmail(userDto.getEmail());
    user.setPhoneNumber(userDto.getPhoneNumber());
    userRepository.save(user);
    return userDto;
  }

  public String Delete(ObjectId id) {
    userRepository.deleteById(id);
    return "User Deleted";
  }
}
