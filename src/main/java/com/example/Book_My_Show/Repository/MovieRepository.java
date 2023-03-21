package com.example.Book_My_Show.Repository;

import com.example.Book_My_Show.Enums.MovieLanguage;
import com.example.Book_My_Show.Model.MovieEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
    //inbuilt but need to define them
    boolean existsByNameAndLanguage(String name, MovieLanguage language);
}
