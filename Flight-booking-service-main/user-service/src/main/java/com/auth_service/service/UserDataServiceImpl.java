package com.auth_service.service;

import com.auth_service.dto.UserDataDTO;
import com.auth_service.entity.UserData;
import com.auth_service.exception.UserNotFoundException;
import com.auth_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDataServiceImpl implements UserDataService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDataDTO> getUserData() {
        return userRepository.findAll()
                .stream().map(UserDataDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public UserDataDTO getUser(Integer id) {
        UserData user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
        return new UserDataDTO(user);
    }

    @Override
    public UserDataDTO newUser(UserDataDTO dto) {
        dto.setUserPassword(passwordEncoder.encode(dto.getUserPassword())); // ✅ Encrypt password
        UserData user = new UserData(dto);
        return new UserDataDTO(userRepository.save(user));
    }

    @Override
    public UserDataDTO updateUser(Integer id, UserDataDTO dto) {
        UserData existing = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));

        existing.setUsername(dto.getUsername() != null ? dto.getUsername() : existing.getUsername());
        existing.setPhoneNo(dto.getPhoneNo() != null ? dto.getPhoneNo() : existing.getPhoneNo());
        existing.setEmail(dto.getEmail() != null ? dto.getEmail() : existing.getEmail());

        if (dto.getUserPassword() != null) {
            existing.setUserPassword(passwordEncoder.encode(dto.getUserPassword())); // ✅ Encrypt updated password
        }

        return new UserDataDTO(userRepository.save(existing));
    }

    @Override
    public void deleteUser(Integer id) {
        UserData user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
        userRepository.delete(user);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }
}