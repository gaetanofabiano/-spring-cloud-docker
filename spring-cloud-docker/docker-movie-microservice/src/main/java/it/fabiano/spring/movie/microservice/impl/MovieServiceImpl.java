package it.fabiano.spring.movie.microservice.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import it.fabiano.spring.movie.microservice.domain.Movie;
import it.fabiano.spring.movie.microservice.service.MovieService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


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
public class MovieServiceImpl implements MovieService{

    private static Logger logger= LoggerFactory.getLogger(MovieServiceImpl.class);
    private AtomicInteger atomicInteger=new AtomicInteger(0);

    public MovieServiceImpl()
    {
        init();
    }

    // In-memory list
    private List<Movie> books = new ArrayList<>();

    private void init()
    {
        addBook("Quantin Tarantino","Kill Bill Vol. 1");
        addBook("Quantin Tarantino","Kill Bill Vol. 2");
        addBook("Wes Anderson ","Grand Budapest Hotel");
    }

    public Movie getMovie(long id) {
        logger.info("Retrieving id {}",id);
        
        //si poteva fare con una lamda, lo so!
        for (Movie book : books) {
            if (book.getId()==id)
            {
                return book;
            }
        }
        return null;
    }

    public long addMovie(Movie book)
    {
        int idTodSet=atomicInteger.getAndIncrement();
        book.setId(idTodSet);
        books.add(book);
        return idTodSet;
    }

    public long addBook(String author, String title) {
        Movie book = new Movie(-1, author, title);
        return addMovie(book);
    }

    public long getMovieCount() {
        return books.size();
    }
    
    public List<Movie> all() {
       
        return books;
    }

}


