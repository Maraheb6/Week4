package com.example.springhw19.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @Column(columnDefinition = "int not null")
    @NotNull(message = "id should not be empty")
    private Integer id;
    @Column(columnDefinition = "VARCHAR(10) not null")
    @NotEmpty(message = "name should not be empty")
    @Size(min = 2,max = 10,message ="name should not be less than 2 and not more 10" )
    private String name;
    @Column(columnDefinition = "VARCHAR(7) not null CHECK(genre='Drama' or genre='Action' or genre='Comedy')")
    @NotEmpty(message = "genre should not be empty")
    //@Pattern(regexp = "^(Drama||Action||Comedy)$",message = "genre should Drama or Action or Comedy only ")
    private String genre;

    @NotNull(message = "rating should not be empty")
    @Min(value = 1 ,message = " rating should not lass than 1 or more than 5")
    @Max(value = 5,message = " rating should not lass than 1 or more than 5")
    private Integer rating;

    @Column(columnDefinition = "int not null")
    @Min(value = 60,message = "duration must be more than 60")
    private Integer duration;
    @NotNull(message = "id should not be empty")
    @Column(columnDefinition = "int not null")
    private Integer directorID;



}
