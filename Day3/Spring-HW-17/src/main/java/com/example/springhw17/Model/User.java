package com.example.springhw17.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "VARCHAR(10)not null")
    @NotEmpty(message = "name should not be empty")
    private String name;
    @NotEmpty(message = "username should not be empty")
    @Column(columnDefinition = "VARCHAR(8) not null unique")
    private String username;
    @NotEmpty(message = "password should not be empty")
    @Column(columnDefinition = "VARCHAR(10) not null")
    private String password;
    @NotEmpty(message = "email should not be empty")
    @Email(message = "not valid email")
    @Column(columnDefinition = "VARCHAR(20) not null unique")
    private String email;
    @NotEmpty(message = "role should not be empty")
    @Column(columnDefinition = "VARCHAR(5) not null CHECK(role='Admin' or role='user')")
    private String role;
    @NotNull(message = "age should not be empty")
    @Column(columnDefinition = "int not null")
    private Integer age;

}
