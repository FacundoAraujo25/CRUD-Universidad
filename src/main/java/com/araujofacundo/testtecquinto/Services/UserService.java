package com.araujofacundo.testtecquinto.Services;

import com.araujofacundo.testtecquinto.DTO.UserDTO;
import com.araujofacundo.testtecquinto.Models.User;

import java.util.List;

public interface UserService {

    void save(User user);

    List<User> getAllUsers();

    List<UserDTO> getAllUsersDTO(List<User> users);

    User findById(Long id);

    User findByEmail(String email);

    UserDTO getUserDTO(User user);



}
