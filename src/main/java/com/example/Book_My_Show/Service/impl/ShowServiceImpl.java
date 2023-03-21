package com.example.Book_My_Show.Service.impl;

import com.example.Book_My_Show.Dtos.PageResponse;
import com.example.Book_My_Show.Dtos.ShowDTO;
import com.example.Book_My_Show.Exceptions.DependencyException;
import com.example.Book_My_Show.Model.*;
import com.example.Book_My_Show.Repository.MovieRepository;
import com.example.Book_My_Show.Repository.ShowRepository;
import com.example.Book_My_Show.Repository.ShowSeatsRepository;
import com.example.Book_My_Show.Repository.TheaterRepository;
import com.example.Book_My_Show.Service.ShowService;
import com.example.Book_My_Show.converter.ShowConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private ShowSeatsRepository showSeatsRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public ShowDTO addShow(ShowDTO show) {
        Optional<MovieEntity> optionalMovie= Optional.of(movieRepository.findById(show.getId()).get());
        if(optionalMovie.isPresent()==false){
            throw new DependencyException("Movie Not Found with ID: "+show.getMovie().getId()+" to add New Show");
        }
        Optional<TheaterEntity> optionalTheater= Optional.of(theaterRepository.findById(show.getTheater().getId()).get());
        if(!optionalTheater.isPresent()){
            throw new DependencyException("Theater Not Found with ID: " + show.getMovie().getId() + " to add New Show");
        }
        ShowEntity showEntity= ShowConverter.toEntity(show);

        showEntity.setMovie(optionalMovie.get());
        showEntity.setTheater(optionalTheater.get());
        showEntity.setSeats(generateShowSeats(showEntity.getTheater().getSeats(),showEntity));

        for(ShowSeatsEntity seatsEntity:showEntity.getSeats()){
            seatsEntity.setShow(showEntity);
        }
        showEntity=showRepository.save(showEntity);

        return ShowConverter.toDto(showEntity);

    }

    public List<ShowSeatsEntity> generateShowSeats(List<TheaterSeatsEntity> theaterSeatsEntities,ShowEntity showEntity){
        List<ShowSeatsEntity> showSeatsEntities=new ArrayList<>();
        for(TheaterSeatsEntity theaterSeatsEntity : theaterSeatsEntities){
            ShowSeatsEntity showSeatsEntity = ShowSeatsEntity.builder()
                    .seatNumber(theaterSeatsEntity .getSeatNumber())
                    .seatType(theaterSeatsEntity .getSeatType())
                    .rate((int) (theaterSeatsEntity.getRate() * showEntity.getRateMultiplier()))
                    .build();

            showSeatsEntities.add(showSeatsEntity);
        }
        return showSeatsRepository.saveAll(showSeatsEntities);
    }
    @Override
    public PageResponse<ShowDTO> searchShows(String movieName, String location, LocalDate date, LocalTime time, int pageNo, int limit) {
        return null;
    }
}
