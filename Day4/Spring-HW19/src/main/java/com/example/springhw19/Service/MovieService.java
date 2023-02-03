package com.example.springhw19.Service;

import com.example.springhw19.ApiException.ApiException;
import com.example.springhw19.Model.Director;
import com.example.springhw19.Model.Movie;
import com.example.springhw19.Repository.DirectorRepository;
import com.example.springhw19.Repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    private  final DirectorRepository directorRepository;

    public List<Movie> getMovie(){
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }

    public boolean updateMovie(Integer id,Movie movie){
        Movie oldMovie=movieRepository.findMovieById(id);
        if(oldMovie==null){
            return false;
        }
        oldMovie.setName(movie.getName());
        oldMovie.setGenre(movie.getGenre());
        oldMovie.setRating(movie.getRating());
        oldMovie.setDuration(movie.getDuration());
        oldMovie.setDirectorID(movie.getDirectorID());

        movieRepository.save(oldMovie);
        return true;
    }

    public boolean deleteMovie(Integer id){
        Movie oldMovie=movieRepository.findMovieById(id);
        if(oldMovie==null){
            return false;
        }
        movieRepository.delete(oldMovie);
        return true;
    }

    // 1 endpoint
      public  Movie getMovieByName(String name){
        Movie movie =movieRepository.findMovieByName(name);
        if(movie==null){
            throw  new ApiException(" Movie name not found");
        }
        return movie;
      }

      // 2  endpoint
    public  Integer getDuration(String name){
        Movie movie =movieRepository.findMovieByName(name);
        if(movie==null){
            throw  new ApiException(" Movie name not found");
        }
        return movie.getDuration();
    }

    // 5  endpoint

    public  Integer getRating(String name){
        Movie movie =movieRepository.findMovieByName(name);
        if(movie==null){
            throw  new ApiException(" Movie name not found");
        }
        return movie.getRating();
    }
    // 6  endpoint

    public List<Movie> findByRating(Integer rating){
        List<Movie>movies=movieRepository.findAllByRatingGreaterThanEqual(rating);
        if(movies==null){
            throw new ApiException("Rating Not Found");
        }
        return movies;
    }

    // 7  endpoint

    public List<Movie> findByGenre(String genre){
        List<Movie>movies=movieRepository.findAllByGenre(genre);
        if(movies==null){
            throw new ApiException("Genre Not Found");
        }
        return movies;
    }
//endpoint 3
   public String findDirectorName(String name){
       Movie movie =movieRepository.findMovieByName(name);
       if(movie==null){
           throw  new ApiException(" Movie name not found");
       }

           Director director = directorRepository.findDirectorById(movie.getDirectorID());
           return director.getName();



   }

   //endpoint4
   public List<Movie>findAllByDirector(Integer id){
        List<Movie>movies=movieRepository.findAllByDirectorID(id);
        if(movies==null){
            throw new ApiException("No movie found by this director");
        }
        return movies;
   }







}
