package com.example.Book_My_Show.Dtos;

import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TicketsDTO {
    private int id;
    private String allottedSeats;
    private double amount;
    private Date bookedAt;
    private ShowDTO show;
}
