package com.example.Book_My_Show.Controller;

import com.example.Book_My_Show.Dtos.UserDTO;
import com.example.Book_My_Show.Service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@Controller
@Log4j2
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("add")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDto){
        return ResponseEntity.ok(userService.addUser(userDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable (name="id") @Min(value=1,message = "User Id Cannot be -ve")int id){
        return ResponseEntity.ok(userService.getUser(id));
    }
}
