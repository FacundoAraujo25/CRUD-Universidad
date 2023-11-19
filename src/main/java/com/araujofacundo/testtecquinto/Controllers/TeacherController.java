package com.araujofacundo.testtecquinto.Controllers;

import com.araujofacundo.testtecquinto.DTO.TeacherDTO;
import com.araujofacundo.testtecquinto.Models.subclass.Teacher;
import com.araujofacundo.testtecquinto.Services.CourseService;
import com.araujofacundo.testtecquinto.Services.TeacherCourseService;
import com.araujofacundo.testtecquinto.Services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private TeacherCourseService teacherCourseService;

    @GetMapping("/teachers")
    public List<TeacherDTO> getAllTeachers(){
        List<Teacher> teachers = teacherService.findAllTeachers();
        return teacherService.getAllTeachersDTO(teachers);
    }

    @GetMapping("/teachers/{id}")
    public TeacherDTO getTeacher(@PathVariable Long id){
        Teacher teacher = teacherService.findById(id);
        return teacherService.getTeacherDTO(teacher);
    }

    @PostMapping("/teachers")
    public ResponseEntity<Object> createUser(@RequestParam String firstName,@RequestParam String lastName,
                                             @RequestParam String email,@RequestParam String password){

        if(firstName.isBlank()){
            return new ResponseEntity<>("Missing first name", HttpStatus.FORBIDDEN);
        }

        if(lastName.isBlank()){
            return new ResponseEntity<>("Missing last name", HttpStatus.FORBIDDEN);
        }

        if(email.isBlank()){
            return new ResponseEntity<>("Missing email", HttpStatus.FORBIDDEN);
        }

        if(password.isBlank()){
            return new ResponseEntity<>("Missing password", HttpStatus.FORBIDDEN);
        }

        Teacher teacher = new Teacher(firstName, lastName, email, password);
        teacherService.save(teacher);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PatchMapping("/teachers/{id}")
    public ResponseEntity<Object> registerTeachersToCourse(@PathVariable Long id, @RequestParam Long courseId){



        return new ResponseEntity<>("Teacher succesfully asigned",HttpStatus.ACCEPTED);
    }
}
