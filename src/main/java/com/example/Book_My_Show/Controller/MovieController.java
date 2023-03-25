package com.example.Book_My_Show.Controller;

import com.example.Book_My_Show.Dtos.MovieDTO;
import com.example.Book_My_Show.Service.MovieService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@Log4j2
@Controller
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("add")
    public ResponseEntity<MovieDTO> addMovie(@RequestBody MovieDTO movieDTO){
        return ResponseEntity.ok(movieService.addMovie(movieDTO));
    }

    @GetMapping("{id}")
    public ResponseEntity<MovieDTO> getUser(@PathVariable(name = "movieId")@Min(value = 1,message = "Movie Id cannot be less than 1")int id){
        return ResponseEntity.ok(movieService.getMovie(id));
    }
}
