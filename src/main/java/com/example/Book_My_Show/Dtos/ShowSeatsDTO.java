package com.example.Book_My_Show.Dtos;

import com.example.Book_My_Show.Enums.SeatType;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ShowSeatsDTO {
    private int id;
    private String seatNumber;
    private int rate;
    private SeatType seatType;
    private boolean booked;
    private Date bookedAt;


}
