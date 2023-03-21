package com.example.Book_My_Show.converter;

import com.example.Book_My_Show.Dtos.UserDTO;
import com.example.Book_My_Show.Model.UserEntity;

public class UserConverter {
    public static UserEntity toEntity(UserDTO userDto) {

        return UserEntity.builder()
                .name(userDto.getName())
                .mobileNo(userDto.getMobileNo())
                .build();

    }

    public static UserDTO toDto(UserEntity userEntity) {

        return UserDTO.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .mobileNo(userEntity.getMobileNo())
                .build();
    }
}
