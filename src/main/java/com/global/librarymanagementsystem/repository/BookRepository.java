package com.global.librarymanagementsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.global.librarymanagementsystem.entity.Book;
@Repository
public interface BookRepository extends CrudRepository<Book,Integer> {

}
