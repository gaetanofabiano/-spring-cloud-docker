package it.fabiano.spring.movie.microservice.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.fabiano.spring.movie.microservice.domain.Movie;
import it.fabiano.spring.movie.microservice.domain.ObjectWithId;
import it.fabiano.spring.movie.microservice.service.MovieService;



/**
* Dummy microservice studies
*
* @author  Gaetano Fabiano
* @version 1.0.0
* @since   2021-24-10
* @updated 2021-25-11 
*/
@RestController
@RequestMapping("/movie")
public class MovieRestController {

	
    private MovieService movieService;
	
	

	@Autowired
	public void setBookService(MovieService movieService) {
		this.movieService = movieService;
	}
	
	public MovieService getMovieService() {
		return movieService;
	}
	
    public MovieRestController() {
		
	}
	private Logger logger=LoggerFactory.getLogger(MovieRestController.class);


    @GetMapping("/movies")
    @ResponseStatus(HttpStatus.OK)
    public List<Movie> all() {
       
        return movieService.all();
    }

    
    
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Movie getBook(@PathVariable("id") Long id) {
        logger.debug("Provider has received request to get person with id: " + id);
        return movieService.getMovie(id);
    }

    @RequestMapping(value = "/add",  method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ObjectWithId addBook(@RequestBody Movie book)
    {
        return new ObjectWithId(movieService.addMovie(book));
    }



	
}
