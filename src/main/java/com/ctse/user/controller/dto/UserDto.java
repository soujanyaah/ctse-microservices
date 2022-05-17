package com.ctse.user.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private ObjectId _id;
    private String name;
    private String username;
    private String email;
    private String phoneNumber;

    public static UserDto convertToDto(com.ctse.user.persistance.model.User user) {
        UserDto userDto =
                UserDto.builder()
                        ._id(user.get_id())
                        .name(user.getName())
                        .username(user.getUsername())
                        .email(user.getEmail())
                        .phoneNumber(user.getPhoneNumber())
                        .build();
        return userDto;
    }
}
