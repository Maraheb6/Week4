package com.example.springhw19.Repository;

import com.example.springhw19.Model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director,Integer> {

    Director findDirectorById(Integer id);


}
