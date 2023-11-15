package com.araujofacundo.testtecquinto.Services.Implement;

import com.araujofacundo.testtecquinto.DTO.UserDTO;
import com.araujofacundo.testtecquinto.Models.User;
import com.araujofacundo.testtecquinto.Repositories.UserRepository;
import com.araujofacundo.testtecquinto.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<UserDTO> getAllUsersDTO(List<User> users) {
        return users.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDTO getUserDTO(User user) {
        return new UserDTO(user);
    }
}
