package com.araujofacundo.testtecquinto.Controllers;

import com.araujofacundo.testtecquinto.DTO.CourseDTO;
import com.araujofacundo.testtecquinto.Models.Course;
import com.araujofacundo.testtecquinto.Services.CourseService;
import com.araujofacundo.testtecquinto.Services.TeacherCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherCourseService teacherCourseService;

    @GetMapping("/courses")
    public List<CourseDTO> getAllCourses(){
        List<Course> courses = courseService.findAllCourses();
        return courseService.getAllCoursesDTO(courses);
    }

    @GetMapping("/courses/{id}")
    public CourseDTO getCourse(@PathVariable Long id){
        Course course = courseService.findById(id);
        return courseService.getCourseDTO(course);
    }

    @PostMapping("/courses")
    public ResponseEntity<Object> createCourse(@RequestParam String name, @RequestParam LocalDate startDate,
                                               @RequestParam LocalDate finishDate){

        if(name.isBlank()){
            return new ResponseEntity<>("Missing first name", HttpStatus.FORBIDDEN);
        }

        if(startDate.isBefore(LocalDate.now())){
            return new ResponseEntity<>("Invalid start date", HttpStatus.FORBIDDEN);
        }

        Course course = new Course(name, startDate, finishDate);
        courseService.save(course);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

}
