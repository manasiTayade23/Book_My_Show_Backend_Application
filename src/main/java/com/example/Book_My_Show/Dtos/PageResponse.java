package com.example.Book_My_Show.Dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PageResponse<T> {
    private int number;
    private int records;
    private int totalRecords;
    private int totalPages;
    private List<T> data;
}
