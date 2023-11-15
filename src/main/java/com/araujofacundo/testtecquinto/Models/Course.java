package com.araujofacundo.testtecquinto.Models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String name;
    private Period period;
    private LocalDate startDate, finishDate;

    //relacion con courses
    @OneToMany(mappedBy = "course",fetch = FetchType.LAZY)
    private Set<UserCourse> users = new HashSet<>();


    public Course() {
    }

    public Course(String name, Period period, LocalDate startDate, LocalDate finishDate) {
        this.name = name;
        this.period = period;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public void addUser (UserCourse user){
        user.setCourse(this);
        users.add(user);
    }

}
