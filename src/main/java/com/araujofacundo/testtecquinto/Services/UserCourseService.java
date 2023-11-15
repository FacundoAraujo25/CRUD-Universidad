package com.araujofacundo.testtecquinto.Services;

import com.araujofacundo.testtecquinto.DTO.UserCourseDTO;
import com.araujofacundo.testtecquinto.Models.User;
import com.araujofacundo.testtecquinto.Models.UserCourse;

import java.util.List;

public interface UserCourseService {

    void save(UserCourse userCourse);

    List<UserCourse> getAllUserCourses();

    List<UserCourseDTO> getAllUserCoursesDTO(List<UserCourse> userCourses);

    UserCourse findById(Long id);

    UserCourseDTO getUserCourseDTO(UserCourse userCourse);



}
