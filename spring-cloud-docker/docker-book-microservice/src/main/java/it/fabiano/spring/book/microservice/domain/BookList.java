package it.fabiano.spring.book.microservice.domain;

import java.util.List;
/**
* Dummy microservice studies
*
* @author  Gaetano Fabiano
* @version 1.0.0
* @since   2021-24-10
* @updated 2021-25-11 
*/
public class BookList {

	private List<Book> data;

	public List<Book> getData() {
		return data;
	}

	public void setData(List<Book> data) {
		this.data = data;
	}
}