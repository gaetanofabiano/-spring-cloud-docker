package it.fabiano.spring.book.microservice.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
* Dummy microservice studies
*
* @author  Gaetano Fabiano
* @version 1.0.0
* @since   2021-24-10
* @updated 2021-25-11 
*/
@SpringBootApplication
@ComponentScan({"it.fabiano"})
@EntityScan("it.fabiano.spring.book.microservice.domain")
public class WebServiceApplication extends SpringBootServletInitializer {

    @Override protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WebServiceApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(WebServiceApplication.class, args);
    }

}