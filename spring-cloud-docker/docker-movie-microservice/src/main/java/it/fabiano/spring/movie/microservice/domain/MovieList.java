package it.fabiano.spring.movie.microservice.domain;

import java.util.List;
/**
* Dummy microservice studies
*
* @author  Gaetano Fabiano
* @version 1.0.0
* @since   2021-24-10
* @updated 2021-25-11 
*/
public class MovieList {

	private List<Movie> data;

	public List<Movie> getData() {
		return data;
	}

	public void setData(List<Movie> data) {
		this.data = data;
	}
}