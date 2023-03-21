package com.example.Book_My_Show.converter;

import com.example.Book_My_Show.Dtos.ShowSeatsDTO;
import com.example.Book_My_Show.Model.ShowSeatsEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

public class ShowSeatsConverter {
    public static List<ShowSeatsDTO> toDto(List<ShowSeatsEntity> seatsEntities) {

        if (!CollectionUtils.isEmpty(seatsEntities)) {
            return seatsEntities.stream().map(ShowSeatsConverter::toDto).collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    public static ShowSeatsDTO toDto(ShowSeatsEntity seatsEntity) {

        return ShowSeatsDTO.builder()
                .id(seatsEntity.getId())
                .seatNumber(seatsEntity.getSeatNumber())
                .rate(seatsEntity.getRate())
                .seatType(seatsEntity.getSeatType())
                .booked(seatsEntity.isBooked())
                .bookedAt(seatsEntity.getBookedAt())
                .build();


    }
}
