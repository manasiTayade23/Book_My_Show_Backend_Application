package com.example.Book_My_Show.Model;

import com.example.Book_My_Show.Enums.TheaterType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.batch.BatchDataSource;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="theater")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TheaterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private TheaterType theaterType;

    private String location;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<ShowEntity> shows=new ArrayList<>();

    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    private List<TheaterSeatsEntity> seats=new ArrayList();
}
