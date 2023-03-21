package com.example.Book_My_Show.Dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDTO {
    private int id;
    private String name;
    private String mobileNo;
    private List<TicketsDTO> tickets;
}
