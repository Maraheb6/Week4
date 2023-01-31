package com.example.springhw17.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
    private String name;
    @Column(columnDefinition = "VARCHAR(8) not null unique")
    private String username;
    @Column(columnDefinition = "VARCHAR(10) not null")
    private String password;
    @Email(message = "not valid email")
    @Column(columnDefinition = "VARCHAR(20) not null unique")
    private String email;
    @Column(columnDefinition = "VARCHAR(5) not null CHECK(role='Admin' or role='user')")
    private String role;

    @Column(columnDefinition = "int not null")
    private Integer age;

}
