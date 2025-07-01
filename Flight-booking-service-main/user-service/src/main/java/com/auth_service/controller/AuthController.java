package com.auth_service.controller;

import com.auth_service.dto.UserDataDTO;
import com.auth_service.service.UserDataService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController

@RequestMapping("/users")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserDataService userDataService;

    @PostMapping("/add")
    public ResponseEntity<UserDataDTO> createUser(@Valid @RequestBody UserDataDTO dto) {
        return ResponseEntity.ok(userDataService.newUser(dto));
    }

    @GetMapping("/getAll")
    public List<UserDataDTO> userData() {
        return userDataService.getUserData();
    }

    @GetMapping("/get/{id}")
    public UserDataDTO userById(@PathVariable Integer id) {
        return userDataService.getUser(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDataDTO> updateUser(@PathVariable Integer id, @Valid @RequestBody UserDataDTO dto) {
        return ResponseEntity.accepted().body(userDataService.updateUser(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        userDataService.deleteUser(id);
        return "User with ID: " + id + " was deleted successfully";
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        userDataService.deleteAll();
        return "All user data was deleted successfully";
    }
}