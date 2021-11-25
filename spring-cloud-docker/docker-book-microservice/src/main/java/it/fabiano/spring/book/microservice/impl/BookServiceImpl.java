package it.fabiano.spring.book.microservice.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import it.fabiano.spring.book.microservice.domain.Book;
import it.fabiano.spring.book.microservice.service.BookService;

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
public class BookServiceImpl implements BookService{

    private static Logger logger= LoggerFactory.getLogger(BookServiceImpl.class);
    private AtomicInteger atomicInteger=new AtomicInteger(0);

    public BookServiceImpl()
    {
        init();
    }

    // In-memory list
    private List<Book> books = new ArrayList<>();

    private void init()
    {
        addBook("Leonard Mlodinow","La passeggiata dell'ubriaco. Le leggi scientifiche del caso");
        addBook("Emanuel Carrère ","Limonov");
    }

    public Book getBook(long id) {
        logger.info("Retrieving id {}",id);
        
        //si poteva fare con una lamda, lo so!
        for (Book book : books) {
            if (book.getId()==id)
            {
                return book;
            }
        }
        return null;
    }

    public long addBook(Book book)
    {
        int idTodSet=atomicInteger.getAndIncrement();
        book.setId(idTodSet);
        books.add(book);
        return idTodSet;
    }

    public long addBook(String author, String title) {
        Book book = new Book(-1, author, title);
        return addBook(book);
    }

    public long getBookCount() {
        return books.size();
    }
    
    public List<Book> all() {
       
        return books;
    }

}


