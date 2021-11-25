package it.fabiano.spring.book.microservice.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import it.fabiano.spring.book.microservice.domain.Book;
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
public interface BookService {
    public Book getBook(long id);

    public long addBook(Book book);

    public long getBookCount();
    
    public List<Book> all();
}
