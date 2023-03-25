package com.example.Book_My_Show.Controller;

import com.example.Book_My_Show.Dtos.TheaterDTO;
import com.example.Book_My_Show.Service.TheaterService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@Log4j2
@Controller
@RequestMapping("theater")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @PostMapping("add")
    public ResponseEntity<TheaterDTO> addUser(@RequestBody TheaterDTO theaterDTO){
        return ResponseEntity.ok(theaterService.addTheater(theaterDTO));
    }

    @GetMapping("{id}")
    public ResponseEntity<TheaterDTO> getUser(@PathVariable (name="id")@Min(value=1,message = "Theater ID cannot be -ve")int id){
        return ResponseEntity.ok(theaterService.getTheater(id));
    }
}
