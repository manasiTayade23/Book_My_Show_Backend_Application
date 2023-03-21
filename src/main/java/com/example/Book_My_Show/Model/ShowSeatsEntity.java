package com.example.Book_My_Show.Model;

import com.example.Book_My_Show.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name="show_seats")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowSeatsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String seatNumber;

    private int rate;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private boolean booked;

    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    private ShowEntity show;

    @ManyToOne
    @JoinColumn
    private TicketEntity ticket;

}
