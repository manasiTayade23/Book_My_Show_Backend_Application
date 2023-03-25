package com.example.Book_My_Show.Service.impl;

import com.example.Book_My_Show.Dtos.TheaterDTO;
import com.example.Book_My_Show.Enums.SeatType;
import com.example.Book_My_Show.Model.TheaterEntity;
import com.example.Book_My_Show.Model.TheaterSeatsEntity;
import com.example.Book_My_Show.Repository.TheaterRepository;
import com.example.Book_My_Show.Repository.TheaterSeatsRepository;
import com.example.Book_My_Show.Service.TheaterService;
import com.example.Book_My_Show.converter.TheaterConverter;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class TheaterServiceImpl implements TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private TheaterSeatsRepository theaterSeatsRepository;


    @Override
    public TheaterDTO addTheater(TheaterDTO theater) {
        TheaterEntity theaterEntity = TheaterConverter.toEntity(theater);
        theaterEntity.getSeats().addAll(getTheaterSeats());
        for(TheaterSeatsEntity seatsEntity : theaterEntity.getSeats()){
            seatsEntity.setTheaterEntity(theaterEntity);
        }
        theaterEntity = theaterRepository.save(theaterEntity);
        
        return TheaterConverter.toDto(theaterEntity);
    }

    @Override
    public TheaterDTO getTheater(int id) {
        Optional<TheaterEntity> theaterEntity = theaterRepository.findById(id);
        if(!theaterEntity.isPresent()){
            throw new EntityNotFoundException("Theater Not Found For Id: "+id);
        }
        return TheaterConverter.toDto(theaterEntity.get());
    }
    private List<TheaterSeatsEntity> getTheaterSeats(){
        List<TheaterSeatsEntity> seats=new ArrayList<>();

        seats.add(getTheaterSeats("1A", SeatType.CLASSIC,100));
        seats.add(getTheaterSeats("1B",SeatType.CLASSIC,100));
        seats.add(getTheaterSeats("1C",SeatType.CLASSIC,100));
        seats.add(getTheaterSeats("1D",SeatType.CLASSIC,100));
        seats.add(getTheaterSeats("1E",SeatType.CLASSIC,100));

        seats.add(getTheaterSeats("2A",SeatType.PREMIUM,200));
        seats.add(getTheaterSeats("2B",SeatType.PREMIUM,200));
        seats.add(getTheaterSeats("2C",SeatType.PREMIUM,200));
        seats.add(getTheaterSeats("2D",SeatType.PREMIUM,200));
        seats.add(getTheaterSeats("2E",SeatType.PREMIUM,200));

        seats=theaterSeatsRepository.saveAll(seats);
        return seats;

    }
    private TheaterSeatsEntity getTheaterSeats(String seatNumber,SeatType seatType,int rate){
        return TheaterSeatsEntity.builder()
                .seatNumber(seatNumber)
                .seatType(seatType)
                .rate(rate)
                .build();
    }
}
