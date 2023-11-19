package com.araujofacundo.testtecquinto.Controllers;

import com.araujofacundo.testtecquinto.DTO.StudentDTO;
import com.araujofacundo.testtecquinto.DTO.TeacherDTO;
import com.araujofacundo.testtecquinto.Models.subclass.Student;
import com.araujofacundo.testtecquinto.Models.subclass.Teacher;
import com.araujofacundo.testtecquinto.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<StudentDTO> getAllStudents(){
        List<Student> students = studentService.findAllStudents();
        return studentService.getAllStudentsDTO(students);
    }

    @GetMapping("/students/{id}")
    public StudentDTO getStudent(@PathVariable Long id){
        Student student = studentService.findById(id);
        return studentService.getStudentDTO(student);
    }

    @PostMapping("/students")
    public ResponseEntity<Object> createStudent(@RequestParam String firstName, @RequestParam String lastName,
                                             @RequestParam String email, @RequestParam String password){

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

        Student student = new Student(firstName, lastName, email, password);
        studentService.save(student);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PatchMapping("/students/{id}")
    public ResponseEntity<Object> registerStudentToCourse(@PathVariable Long id, @RequestParam Long courseId){



        return new ResponseEntity<>("Student succesfully asigned",HttpStatus.ACCEPTED);
    }

}
