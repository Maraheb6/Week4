package com.example.springhw19.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Director {
    @Id
    @Column(columnDefinition = "int not null")
    @NotNull(message = "id should not be empty")
    private Integer id;

    @Column(columnDefinition = "VARCHAR(10) not null")
    @NotEmpty(message = "name should not be empty")
    @Size(min = 2,max = 10,message ="name should not be less than 2 and not more 10" )
    private String name;

}
