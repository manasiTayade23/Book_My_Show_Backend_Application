package com.example.Book_My_Show.Service;

import com.example.Book_My_Show.Dtos.TheaterDTO;
import org.springframework.stereotype.Service;

@Service
public interface TheaterService {
    public TheaterDTO addTheater(TheaterDTO theater) ;

    public TheaterDTO getTheater(int id);
}
