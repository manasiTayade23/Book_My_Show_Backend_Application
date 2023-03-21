package com.example.Book_My_Show.Dtos;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ShowDTO {
    private int id;
    private LocalDate showDate;
    private LocalTime showTime;
    private MovieDTO movie;
    private TheaterDTO theater;
    private Date createdOn;
    private Date updatedAt;
    private MovieDTO movieDTO;
    private TheaterDTO theaterDTO;
    private List<ShowSeatsDTO> seats;
}
