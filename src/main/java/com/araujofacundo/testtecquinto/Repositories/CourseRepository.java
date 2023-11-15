package com.araujofacundo.testtecquinto.Repositories;

import com.araujofacundo.testtecquinto.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CourseRepository extends JpaRepository <Course, Long> {



}
