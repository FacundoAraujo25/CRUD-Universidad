package com.araujofacundo.testtecquinto.DTO;

import com.araujofacundo.testtecquinto.Models.Course;
import com.araujofacundo.testtecquinto.Models.Period;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Set;

@Getter
public class CourseDTO {

    private long id;
    private String name;
    private Period period;
    private LocalDate startDate, finishDate;
    private Set<UserCourseDTO> users;

    public CourseDTO() {
    }

    public CourseDTO(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.period = course.getPeriod();
        this.startDate = course.getStartDate();
        this.finishDate = course.getFinishDate();
        this.users = course.getUsers();
    }
}
