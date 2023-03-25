package com.example.Book_My_Show.Controller;

import com.example.Book_My_Show.Dtos.PageResponse;
import com.example.Book_My_Show.Dtos.ShowDTO;
import com.example.Book_My_Show.Service.ShowService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.time.LocalTime;

@Log4j2
@Controller
@RequestMapping("show")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("add")
    public ResponseEntity<ShowDTO> addShow(@RequestBody ShowDTO showDTO){
        return ResponseEntity.ok(showService.addShow(showDTO));
    }

    public ResponseEntity<PageResponse<ShowDTO>> search(
            @PathVariable(name="pageNo") @Min(value = 1,message = "Page Number Cannot be less than 1")int pageNo,
            @PathVariable(name="limit")@Min(value = 1,message = "Limit cannot be less than 1")int limit,
            @RequestParam(name="movieName",required = false) String movieName,
            @RequestParam(name="city",required = false) String city,
            @RequestParam(name="showDate",required = false) @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate showDate,
            @RequestParam(name="showTime",required = false)@DateTimeFormat(pattern = "HH:mm:ss")LocalTime showTime){
        return ResponseEntity.ok(showService.searchShows(movieName,city,showDate,showTime,pageNo,limit));
    }
}
