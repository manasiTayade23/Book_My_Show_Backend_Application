package com.example.Book_My_Show.Repository;

import com.example.Book_My_Show.Model.TheaterEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<TheaterEntity, Integer> {
}
