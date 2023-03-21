package com.example.Book_My_Show.Dtos;

import com.example.Book_My_Show.Enums.TheaterType;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TheaterDTO {
    private int id;
    private String name;
    private TheaterType theaterType;
    private String location;
    private List<ShowDTO> showDTOS;
}
