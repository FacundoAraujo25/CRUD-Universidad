package com.araujofacundo.testtecquinto;

import com.araujofacundo.testtecquinto.Models.Course;
import com.araujofacundo.testtecquinto.Models.Period;
import com.araujofacundo.testtecquinto.Models.StudentTeacherCourse;
import com.araujofacundo.testtecquinto.Models.TeacherCourse;
import com.araujofacundo.testtecquinto.Models.subclass.Student;
import com.araujofacundo.testtecquinto.Models.subclass.Teacher;
import com.araujofacundo.testtecquinto.Services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class TestTecQuintoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestTecQuintoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(CourseService courseService, TeacherService teacherService, StudentService studentService, TeacherCourseService teacherCourseService, StudentTeacherCourseService studentTeacherCourseService){
		return (args -> {

			Teacher teacher1 = new Teacher("Gabriela","Rossi","gabiRossi@gmail.com","gabi123");
			Teacher teacher2 = new Teacher("Facundo", "Araujo","facu@gmail.com","facu123");

			Student student1 = new Student("Agustin","Araujo","agu@gmail.com","agu123");
			Student student2 = new Student("Yuli","Rossi","yuli@gmail.com","yuli123");
			Student student3 = new Student("Juako","Rossi","juako@gmail.com","juako123");

			studentService.save(student1);
			studentService.save(student2);
			studentService.save(student3);

			Course course1 = new Course("Java Course", LocalDate.now(),LocalDate.now().plusMonths(6));
			Course course2 = new Course("Front-End Course", LocalDate.now(),LocalDate.now().plusMonths(6));
			Course course3 = new Course("Big Data Course", LocalDate.now(),LocalDate.now().plusMonths(4));
			Course course4 = new Course("Prompt-Engineering Course", LocalDate.now(),LocalDate.now().plusMonths(3));
			TeacherCourse teacherCourse1 = new TeacherCourse(Period.MORNING);
			TeacherCourse teacherCourse2 = new TeacherCourse(Period.MORNING);
			TeacherCourse teacherCourse3 = new TeacherCourse(Period.AFTERNOON);
			TeacherCourse teacherCourse4 = new TeacherCourse(Period.NIGHT);
			TeacherCourse teacherCourse5 = new TeacherCourse(Period.AFTERNOON);

			courseService.save(course1);
			courseService.save(course2);
			courseService.save(course3);
			courseService.save(course4);
			teacherService.save(teacher1);
			teacherService.save(teacher2);

			teacher1.asignCourse(teacherCourse1);
			course1.addTeacher(teacherCourse1);

			teacher2.asignCourse(teacherCourse2);
			course2.addTeacher(teacherCourse2);

			teacher1.asignCourse(teacherCourse3);
			course3.addTeacher(teacherCourse3);
			teacher2.asignCourse(teacherCourse5);
			course3.addTeacher(teacherCourse5);

			teacher1.asignCourse(teacherCourse4);
			course4.addTeacher(teacherCourse4);

			teacherCourseService.save(teacherCourse1);
			teacherCourseService.save(teacherCourse2);
			teacherCourseService.save(teacherCourse3);
			teacherCourseService.save(teacherCourse4);
			teacherCourseService.save(teacherCourse5);
			courseService.save(course1);
			courseService.save(course2);
			courseService.save(course3);
			courseService.save(course4);
			teacherService.save(teacher1);
			teacherService.save(teacher2);


			StudentTeacherCourse studentTeacherCourse1 = new StudentTeacherCourse(LocalDateTime.now());
			StudentTeacherCourse studentTeacherCourse2 = new StudentTeacherCourse(LocalDateTime.now().plusHours(1));
			StudentTeacherCourse studentTeacherCourse3 = new StudentTeacherCourse(LocalDateTime.now().plusHours(2));
			StudentTeacherCourse studentTeacherCourse4 = new StudentTeacherCourse(LocalDateTime.now().plusHours(3));

			studentTeacherCourseService.save(studentTeacherCourse1);
			studentTeacherCourseService.save(studentTeacherCourse2);
			studentTeacherCourseService.save(studentTeacherCourse3);
			studentTeacherCourseService.save(studentTeacherCourse4);

			teacherCourse1.addStudent(studentTeacherCourse1);
			student1.addCourse(studentTeacherCourse1);

			teacherCourse2.addStudent(studentTeacherCourse2);
			student2.addCourse(studentTeacherCourse2);

			teacherCourse3.addStudent(studentTeacherCourse3);
			student2.addCourse(studentTeacherCourse2);
			student3.addCourse(studentTeacherCourse2);

			teacherCourse4.addStudent(studentTeacherCourse4);
			student3.addCourse(studentTeacherCourse4);

			studentTeacherCourseService.save(studentTeacherCourse1);
			studentTeacherCourseService.save(studentTeacherCourse2);
			studentTeacherCourseService.save(studentTeacherCourse3);
			studentTeacherCourseService.save(studentTeacherCourse4);

			teacherCourseService.save(teacherCourse1);
			teacherCourseService.save(teacherCourse2);
			teacherCourseService.save(teacherCourse3);
			teacherCourseService.save(teacherCourse4);

			studentService.save(student1);
			studentService.save(student2);
			studentService.save(student3);

		});

		}

}
