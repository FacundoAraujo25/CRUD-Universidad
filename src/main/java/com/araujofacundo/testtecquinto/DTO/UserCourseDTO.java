package com.araujofacundo.testtecquinto.DTO;

import com.araujofacundo.testtecquinto.Models.UserCourse;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserCourseDTO {

    private long id;
    private LocalDateTime registeredAt;
    private String user;
    private String courseName;

    public UserCourseDTO() {
    }

    public UserCourseDTO(UserCourse userCourse) {
        this.id = userCourse.getId();
        this.registeredAt = userCourse.getRegisteredAt();
        this.user = userCourse.getUser().getFullName();
        this.courseName = userCourse.getCourse().getName();
    }

}
