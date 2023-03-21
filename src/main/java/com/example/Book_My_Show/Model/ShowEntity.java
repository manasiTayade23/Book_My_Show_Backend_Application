package com.example.Book_My_Show.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="show")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class ShowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="show_date",columnDefinition = "DATE",nullable = false)
    private LocalDate showDate;

    @Column(name="show_time",columnDefinition = "TIME",nullable = false)
    private LocalTime showTime;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedAt;

    @ManyToOne
    @JoinColumn
    private MovieEntity movie;

    @ManyToOne
    @JoinColumn
    private TheaterEntity theater;

    @Column(name = "rate_multiplier", columnDefinition = "float(2,1) default 1.0", nullable = false)
    private float rateMultiplier;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<TicketEntity> tickets;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<ShowSeatsEntity> seats;
}
