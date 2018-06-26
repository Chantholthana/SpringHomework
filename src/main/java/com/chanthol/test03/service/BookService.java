package com.chanthol.test03.service;

import com.chanthol.test03.models.Book;

import java.util.List;

public interface BookService {
   List<Book> getAll();

   Book viewOne(Integer id);

   boolean update(Book book);

   boolean delete(Integer id);

   boolean create(Book book);

}
