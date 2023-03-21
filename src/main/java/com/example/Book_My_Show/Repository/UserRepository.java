package com.example.Book_My_Show.Repository;

import com.example.Book_My_Show.Model.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    boolean existsByMobile(String mobile);

    @Transactional
    void deleteByMobile(String mobile);
}
