package com.example.Book_My_Show.converter;

import com.example.Book_My_Show.Dtos.TicketsDTO;
import com.example.Book_My_Show.Model.TicketEntity;

public class TicketConverter {
    public static TicketEntity toEntity(TicketsDTO ticketDto) {

        return TicketEntity.builder()
                .allottedSeats(ticketDto.getAllottedSeats())
                .amount(ticketDto.getAmount())
                .build();

    }

    public static TicketsDTO toDto(TicketEntity ticketEntity) {

        return TicketsDTO.builder()
                .id(ticketEntity.getId())
                .allottedSeats(ticketEntity.getAllottedSeats())
                .amount(ticketEntity.getAmount())
                .show(ShowConverter.toDto(ticketEntity.getShowEntity()))
                .build();
    }
}
