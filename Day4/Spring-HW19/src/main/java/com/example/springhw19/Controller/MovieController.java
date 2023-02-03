package com.example.springhw19.Controller;

import com.example.springhw19.ApiException.ApiException;
import com.example.springhw19.Model.Movie;
import com.example.springhw19.Service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
@RequiredArgsConstructor
public class MovieController {
    private  final MovieService movieService;
    @GetMapping("/get")
    public ResponseEntity getMovie(){
        List<Movie> movie=movieService.getMovie();
        return ResponseEntity.status(200).body(movie);
    }
    @PostMapping("/add")
    public ResponseEntity addMovie(@Valid @RequestBody Movie movie){

        movieService.addMovie(movie);
        return ResponseEntity.status(200).body("Movie Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMovie(@PathVariable Integer id,@Valid@RequestBody Movie movie){
        boolean isUpdate= movieService.updateMovie(id,movie);
        if(isUpdate) {
            return ResponseEntity.status(200).body("Movie Updated");
        }
        throw new ApiException("Wrong Id");
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity deleteMovie(@PathVariable Integer id){
        boolean isDelete= movieService.deleteMovie(id);
        if(isDelete) {
            return ResponseEntity.status(200).body("Movie Deleted");
        }
        throw new ApiException("wrong Id");
    }

    // 1 endpoint
    @GetMapping("/bymoviename/{name}")
    public  ResponseEntity getMovieByName(@PathVariable String name){
        Movie movie=movieService.getMovieByName(name);

        return  ResponseEntity.status(200).body(movie);
    }

    // 2  endpoint
    @GetMapping("/findduration/{name}")
    public  ResponseEntity getDuration(@PathVariable String name){
        Integer duration =movieService.getDuration(name);

        return  ResponseEntity.status(200).body(duration);
    }

    // 5 endpoint

    @GetMapping("/findrating/{name}")
    public  ResponseEntity getRating(@PathVariable String name){
        Integer duration =movieService.getRating(name);

        return  ResponseEntity.status(200).body(duration);
    }
    // 6 endpoint
    @GetMapping("/byrating/{rating}")
    public ResponseEntity getByRating(@PathVariable Integer rating){
        List<Movie>movies=movieService.findByRating(rating);
        return ResponseEntity.status(200).body(movies);
    }

    // 7 endpoint
    @GetMapping("/bygenre/{genre}")
    public ResponseEntity getByGenre(@PathVariable String genre){
        List<Movie>movies=movieService.findByGenre(genre);
        return ResponseEntity.status(200).body(movies);
    }

    // 3 endpoint

    @GetMapping("/getdirectorname/{name}")
    public ResponseEntity getDirectorName(String name){
        String directorName=movieService.findDirectorName(name);
        return ResponseEntity.status(200).body(directorName);
    }
    // 4 endpoint
    @GetMapping("/getall/{name}")
    public ResponseEntity getAllByDirector(Integer id){
        List<Movie>movies=movieService.findAllByDirector(id);
        return ResponseEntity.status(400).body(movies);
    }


    }


