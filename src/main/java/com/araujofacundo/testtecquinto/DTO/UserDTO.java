package com.araujofacundo.testtecquinto.DTO;

import com.araujofacundo.testtecquinto.Models.Role;
import com.araujofacundo.testtecquinto.Models.User;
import lombok.Getter;

import java.util.Set;

@Getter
public class UserDTO {

    private long id;
    private String firstName, lastName, email, password;
    private Role role;
    private Set<UserCourseDTO> courses;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.role = user.getRole();
        this.courses = user.getCourses();
    }
}
