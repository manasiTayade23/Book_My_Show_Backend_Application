package com.example.Book_My_Show.Dtos;

import com.example.Book_My_Show.Enums.CertificateType;
import com.example.Book_My_Show.Enums.MovieLanguage;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MovieDTO {
    private int id;
    private String name;
    private MovieLanguage movieLanguage;
    private CertificateType certificateType;
    private LocalDate releaseDate;
}
