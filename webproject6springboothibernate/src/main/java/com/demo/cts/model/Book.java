package com.demo.cts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book_master")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="book_id")
	private int bookId;
	@Column(name="book_title")
	private String bookTitle;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int bookId, String bookTitle) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookId;
		result = prime * result + ((bookTitle == null) ? 0 : bookTitle.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (bookId != other.bookId)
			return false;
		if (bookTitle == null) {
			if (other.bookTitle != null)
				return false;
		} else if (!bookTitle.equals(other.bookTitle))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + "]";
	}
	
	
	
}
