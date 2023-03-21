package com.example.Book_My_Show.Model;

import com.example.Book_My_Show.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="theater_seats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TheaterSeatsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String seatNumber;

    private int rate;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    @JoinColumn
    private TheaterEntity theaterEntity;
}
