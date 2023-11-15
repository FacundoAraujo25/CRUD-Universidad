package com.araujofacundo.testtecquinto.Models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String firstName, lastName, email, password;
    private Role role;

    //relacion con courses
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private Set<UserCourse> courses = new HashSet<>();

    public User() {
    }

    public User(String firstName, String lastName, String email, String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public void addCourse(UserCourse course){
        course.setUser(this);
        courses.add(course);
    }

    public String getFullName(){
        return "( "+this.getRole()+" )" + this.getFirstName() + " " + this.getLastName();
    }
}
