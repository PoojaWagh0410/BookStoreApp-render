package com.pooja.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pooja.springboot.entity.BookList;

@Repository
public interface BookListRepository extends JpaRepository<BookList, Integer> {


}
