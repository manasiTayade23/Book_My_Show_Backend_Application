package com.example.Book_My_Show.converter;

import com.example.Book_My_Show.Dtos.ShowDTO;
import com.example.Book_My_Show.Model.ShowEntity;

public class ShowConverter {
    public static ShowEntity toEntity(ShowDTO showDTO){
        return ShowEntity.builder()
                .showTime(showDTO.getShowTime())
                .showDate(showDTO.getShowDate())
                .build();
    }
    public static ShowDTO toDto(ShowEntity show){
        return ShowDTO.builder()
                .id(show.getId())
                .showDate(show.getShowDate())
                .showTime(show.getShowTime())
                .movie(MovieConverter.toDto(show.getMovie()))
                .theater(TheaterConverter.toDto(show.getTheater()))
                .seats(ShowSeatsConverter.toDto(show.getSeats()))
                .createdOn(show.getCreatedOn())
                .updatedAt(show.getUpdatedAt())
                .build();
    }
}
