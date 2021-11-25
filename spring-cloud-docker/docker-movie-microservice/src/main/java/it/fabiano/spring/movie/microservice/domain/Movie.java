package it.fabiano.spring.movie.microservice.domain;

/**
* Dummy microservice studies
*
* @author  Gaetano Fabiano
* @version 1.0.0
* @since   2021-24-10
* @updated 2021-25-11 
*/
public class Movie extends ObjectWithId{
    private String director;
    private String title;

    public Movie() {
    }

    public Movie(long id,String author, String title)
    {
        super(id);
        this.director = author;
        this.title = title;
    }


    public String getDirector() {
        return director;
    }

    public String getTitle() {
        return title;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie book = (Movie) o;

        return id == book.id;

    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
