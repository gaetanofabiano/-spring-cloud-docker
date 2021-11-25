package it.fabiano.spring.movie.microservice.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import it.fabiano.spring.movie.microservice.domain.Movie;
/**
* Dummy microservice studies
*
* @author  Gaetano Fabiano
* @version 1.0.0
* @since   2021-24-10
* @updated 2021-25-11 
*/
@Repository
@Service
public interface MovieService {
    public Movie getMovie(long id);

    public long addMovie(Movie book);

    public long getMovieCount();
    
    public List<Movie> all();
}
