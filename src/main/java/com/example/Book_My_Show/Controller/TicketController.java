package com.example.Book_My_Show.Controller;

import com.example.Book_My_Show.Dtos.BookTicketReqDTO;
import com.example.Book_My_Show.Dtos.TicketsDTO;
import com.example.Book_My_Show.Repository.TicketRepository;
import com.example.Book_My_Show.Service.TicketService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@Log4j2
@Controller
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("book")
    public ResponseEntity<TicketsDTO> bookTicket(@RequestBody BookTicketReqDTO  bookTicketReqDTO){
        return ResponseEntity.ok(ticketService.bookTicket(bookTicketReqDTO));
    }

    @GetMapping("{id}")
    public ResponseEntity<TicketsDTO> getTicket(@PathVariable(name="id")@Min(value=1,message = "Ticket ID Cannot Be -ve")int id){
        return ResponseEntity.ok(ticketService.getTicket(id));
    }
}
