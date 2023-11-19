package com.araujofacundo.testtecquinto.DTO;

import com.araujofacundo.testtecquinto.Models.StudentTeacherCourse;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class StudentTeacherCourseDTO {

    private LocalDateTime registeredDate;
    private long idStudentTeacherCourse, idStudent, idTeacherCourse;

    public StudentTeacherCourseDTO(StudentTeacherCourse studentTeacherCourse){
        this.idStudentTeacherCourse = studentTeacherCourse.getId();
        this.idStudent= studentTeacherCourse.getStudent().getId();
        this.idTeacherCourse = studentTeacherCourse.getCourse().getId();
        this.registeredDate = studentTeacherCourse.getRegisteredDate();
    }

}
