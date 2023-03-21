package com.example.Book_My_Show.Service.impl;

import com.example.Book_My_Show.Dtos.TheaterDTO;
import com.example.Book_My_Show.Model.TheaterEntity;
import com.example.Book_My_Show.Repository.TheaterRepository;
import com.example.Book_My_Show.Repository.TheaterSeatsRepository;
import com.example.Book_My_Show.Service.TheaterService;
import com.example.Book_My_Show.converter.TheaterConverter;
import org.springframework.beans.factory.annotation.Autowired;

public class TheaterServiceImpl implements TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private TheaterSeatsRepository theaterSeatsRepository;


    @Override
    public TheaterDTO addTheater(TheaterDTO theater) {
        if(theater.getName()==null||theater.getLocation()==null){
            throw new Exception("Name and location should valid");
        }

        TheaterEntity theaterEntity = TheaterConvertors.convertDtoToEntity(theaterEntryDto);
        List<TheaterSeatEntity> theaterSeatEntityList = createTheaterSeats(theaterEntryDto,theaterEntity);

        theaterEntity.setTheaterSeatEntityList(theaterSeatEntityList);
        theaterRepository.save(theaterEntity);

    }

    @Override
    public TheaterDTO getTheater(int id) {
        return null;
    }
}
