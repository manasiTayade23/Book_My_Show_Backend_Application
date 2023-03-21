package com.example.Book_My_Show.converter;

import com.example.Book_My_Show.Dtos.TheaterDTO;
import com.example.Book_My_Show.Model.TheaterEntity;

public class TheaterConverter {
    public static TheaterEntity toEntity(TheaterDTO theaterDto) {

        return TheaterEntity.builder()
                .name(theaterDto.getName())
                .theaterType(theaterDto.getTheaterType())
                .location(theaterDto.getLocation())
                .build();
    }
    public static TheaterDTO toDto(TheaterEntity theaterEntity) {

        return TheaterDTO.builder()
                .id(theaterEntity.getId())
                .name(theaterEntity.getName())
                .location(theaterEntity.getLocation())
                .theaterType(theaterEntity.getTheaterType())
                .build();
    }
}
