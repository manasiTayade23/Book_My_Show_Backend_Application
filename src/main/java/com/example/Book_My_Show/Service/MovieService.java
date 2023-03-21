package com.example.Book_My_Show.Service;

import com.example.Book_My_Show.Dtos.MovieDTO;

public interface MovieService {
    public MovieDTO addMovie(MovieDTO movie);

    public MovieDTO getMovie(int id);
}
