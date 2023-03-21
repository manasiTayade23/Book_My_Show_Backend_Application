package com.example.Book_My_Show.Dtos;

import com.example.Book_My_Show.Enums.SeatType;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BookTicketReqDTO {
    private Set<String> seatNumber;
    private int id;
    private int showId;
    private SeatType seatType;
}
