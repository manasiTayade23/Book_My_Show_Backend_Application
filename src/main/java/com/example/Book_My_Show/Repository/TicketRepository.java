package com.example.Book_My_Show.Repository;

import com.example.Book_My_Show.Model.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity,Integer> {
}
