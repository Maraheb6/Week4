package com.example.springhw19.Repository;

import com.example.springhw19.Model.Director;
import com.example.springhw19.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    Movie findMovieById(Integer id);

    Movie findMovieByName(String name);

    List<Movie> findAllByRatingGreaterThanEqual(Integer rating);

    List<Movie> findAllByGenre(String genre );
   List<Movie> findAllByDirectorID(Integer id);

}
