package com.example.Book_My_Show.Service;

import com.example.Book_My_Show.Dtos.PageResponse;
import com.example.Book_My_Show.Dtos.ShowDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
@Service
public interface ShowService {
    public ShowDTO addShow(ShowDTO show);

    PageResponse<ShowDTO> searchShows(String movieName, String location, LocalDate date, LocalTime time, int pageNo, int limit);
}
