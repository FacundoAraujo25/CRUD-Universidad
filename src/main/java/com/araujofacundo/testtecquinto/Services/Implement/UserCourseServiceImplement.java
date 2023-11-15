package com.araujofacundo.testtecquinto.Services.Implement;

import com.araujofacundo.testtecquinto.DTO.UserCourseDTO;
import com.araujofacundo.testtecquinto.Models.UserCourse;
import com.araujofacundo.testtecquinto.Repositories.UserCourseRepository;
import com.araujofacundo.testtecquinto.Services.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserCourseServiceImplement implements UserCourseService {

    @Autowired
    private UserCourseRepository userCourseRepository;

    @Override
    public void save(UserCourse userCourse) {
        userCourseRepository.save(userCourse);
    }

    @Override
    public List<UserCourse> getAllUserCourses() {
        return userCourseRepository.findAll();
    }

    @Override
    public List<UserCourseDTO> getAllUserCoursesDTO(List<UserCourse> userCourses) {
        return userCourses.stream().map(userCourse -> new UserCourseDTO(userCourse)).collect(Collectors.toList());
    }

    @Override
    public UserCourse findById(Long id) {
        return userCourseRepository.findById(id).orElse(null);
    }

    @Override
    public UserCourseDTO getUserCourseDTO(UserCourse userCourse) {
        return new UserCourseDTO(userCourse);
    }
}
