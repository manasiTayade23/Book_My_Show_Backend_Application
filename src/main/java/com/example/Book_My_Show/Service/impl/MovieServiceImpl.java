package com.example.Book_My_Show.Service.impl;

import com.example.Book_My_Show.Dtos.MovieDTO;
import com.example.Book_My_Show.Exceptions.DuplicateRecordException;
import com.example.Book_My_Show.Model.MovieEntity;
import com.example.Book_My_Show.Repository.MovieRepository;
import com.example.Book_My_Show.Service.MovieService;
import com.example.Book_My_Show.converter.MovieConverter;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;


    @Override
    public MovieDTO addMovie(MovieDTO movie) {
        if(movieRepository.existsByNameAndLanguage(movie.getName(),movie.getMovieLanguage())){
            throw new DuplicateRecordException("Movie Already Exists with Name: "+movie.getName()+" in Language: "+movie.getMovieLanguage());
        }
        MovieEntity movieEntity = MovieConverter.toEntity(movie);
        movieEntity = movieRepository.save(movieEntity);

        return MovieConverter.toDto(movieEntity);

    }

    @Override
    public MovieDTO getMovie(int id) {
        Optional<MovieEntity> movieEntity = Optional.of(movieRepository.findById(id).get());
        if(movieEntity.isPresent()==false){
            throw new EntityNotFoundException("Movie Not Found With id: "+id);
        }
        return MovieConverter.toDto(movieEntity.get());

    }
}
