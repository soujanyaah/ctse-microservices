package com.ctse.user.controller;

import com.ctse.user.controller.dto.PageableDto;
import com.ctse.user.controller.dto.UserDto;
import com.ctse.user.persistance.model.PageableEntityData;
import com.ctse.user.persistance.model.User;
import com.ctse.user.service.UserService;
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
@RequestMapping("/api/user")
public class UserController {

  @Autowired UserService userService;

  @GetMapping()
  public PageableDto<UserDto> getUser(
      @PageableDefault()
          @SortDefault.SortDefaults({@SortDefault(sort = "name", direction = Sort.Direction.ASC)})
          Pageable pageable) {
    PageableEntityData<User> serviceData = userService.getUserList(pageable);
    List<UserDto> userList =
        serviceData.getData().stream().map(UserDto::convertToDto).collect(Collectors.toList());

    return new PageableDto<>(userList, serviceData.getTotalRecords());
  }

  @PostMapping()
  public UserDto createUser(@Validated @RequestBody UserDto userDto) {
    return userService.create(userDto);
  }

  @PutMapping("/{objectId}")
  public UserDto updateUser(
      @PathVariable ObjectId objectId, @Validated @RequestBody UserDto userDto) {
    return userService.update(objectId, userDto);
  }

  @DeleteMapping("/{objectId}")
  public String deleteUser(@PathVariable ObjectId objectId) {
    return userService.Delete(objectId);
  }
}
