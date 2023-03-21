package com.example.Book_My_Show.Service;

import com.example.Book_My_Show.Dtos.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public UserDTO addUser(UserDTO user);

    public UserDTO getUser(int id);
}
