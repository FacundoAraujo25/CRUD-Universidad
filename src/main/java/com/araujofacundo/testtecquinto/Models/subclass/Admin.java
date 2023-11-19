package com.araujofacundo.testtecquinto.Models.subclass;

import com.araujofacundo.testtecquinto.Models.supclass.User;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Admin extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    public Admin(@NonNull String firstName, @NonNull String lastName, @NonNull String email, @NonNull String password) {
        super(firstName, lastName, email, password);
    }
}
