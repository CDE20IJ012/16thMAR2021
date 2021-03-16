package com.demo.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.cts.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
