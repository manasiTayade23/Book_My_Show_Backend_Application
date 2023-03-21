package com.example.Book_My_Show.converter;

import com.example.Book_My_Show.Dtos.MovieDTO;
import com.example.Book_My_Show.Model.MovieEntity;

public class MovieConverter {

    public static MovieEntity toEntity(MovieDTO movie){
        return MovieEntity.builder()
                .name(movie.getName())
                .movieLanguage(movie.getMovieLanguage())
                .certificateType(movie.getCertificateType())
                .releaseDate(movie.getReleaseDate())
                .build();
    }

    public static MovieDTO toDto(MovieEntity movieEntity){
        return MovieDTO.builder()
                .id(movieEntity.getId())
                .movieLanguage(movieEntity.getMovieLanguage())
                .name(movieEntity.getName())
                .certificateType(movieEntity.getCertificateType())
                .releaseDate(movieEntity.getReleaseDate())
                .build();

    }
}
