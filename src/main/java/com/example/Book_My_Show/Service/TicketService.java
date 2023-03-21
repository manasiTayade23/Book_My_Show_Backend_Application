package com.example.Book_My_Show.Service;

import com.example.Book_My_Show.Dtos.BookTicketReqDTO;
import com.example.Book_My_Show.Dtos.TicketsDTO;
import org.springframework.stereotype.Service;

@Service
public interface TicketService {
    public TicketsDTO bookTicket(BookTicketReqDTO ticket);

    public TicketsDTO getTicket(int id);

}

