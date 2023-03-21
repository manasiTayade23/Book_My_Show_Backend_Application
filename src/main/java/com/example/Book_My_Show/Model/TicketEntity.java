package com.example.Book_My_Show.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="tickets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String allottedSeats;

    private double amount;
    @CreationTimestamp
    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<ShowSeatsEntity> seats;
}
