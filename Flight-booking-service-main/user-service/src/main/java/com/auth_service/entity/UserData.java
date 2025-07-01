package com.auth_service.entity;

import com.auth_service.dto.UserDataDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phoneNo;

    @Column(nullable = false)
    private String userPassword;


    public UserData(UserDataDTO dto) {
        this.userId=dto.getUserId();
        this.username=dto.getUsername();
        this.phoneNo=dto.getPhoneNo();
        this.email=dto.getEmail();
        this.userPassword=dto.getUserPassword();
    }
}