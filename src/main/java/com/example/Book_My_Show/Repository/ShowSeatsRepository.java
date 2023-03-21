package com.example.Book_My_Show.Repository;

import com.example.Book_My_Show.Model.ShowSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatsRepository extends JpaRepository<ShowSeatsEntity,Integer> {
}
