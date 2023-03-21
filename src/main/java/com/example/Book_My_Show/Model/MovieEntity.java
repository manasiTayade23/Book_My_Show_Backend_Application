package com.example.Book_My_Show.Model;

import com.example.Book_My_Show.Enums.CertificateType;
import com.example.Book_My_Show.Enums.MovieLanguage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="movie")
@Builder
@ToString
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name",nullable = false)
    private String name;

    @Enumerated(value = EnumType.STRING)
    private MovieLanguage movieLanguage;

    @Enumerated(value = EnumType.STRING)
    @Column(name="certificate_type",nullable = false)
    private CertificateType certificateType;

    @Column(name="release_date",columnDefinition = "DATE",nullable = false)
    private LocalDate releaseDate;

    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowEntity> shows=new ArrayList();

}
