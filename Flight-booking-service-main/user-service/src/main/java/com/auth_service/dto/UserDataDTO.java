package com.auth_service.dto;

import com.auth_service.entity.UserData;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDataDTO {
    private int userId;

    @NotBlank(message = "Username cannot be blank")
    private String username;

    @NotBlank(message = "Phone number cannot be blank")
    private String phoneNo;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 4, message = "Password must be at least 4 characters")
    private String userPassword;

    public UserDataDTO(UserData userData) {
        this.userId = userData.getUserId();
        this.username = userData.getUsername();
        this.phoneNo = userData.getPhoneNo();
        this.email = userData.getEmail();
        this.userPassword = userData.getUserPassword();
    }
}