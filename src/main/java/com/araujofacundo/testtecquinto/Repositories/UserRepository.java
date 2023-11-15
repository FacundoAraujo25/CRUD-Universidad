package com.araujofacundo.testtecquinto.Repositories;

import com.araujofacundo.testtecquinto.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
