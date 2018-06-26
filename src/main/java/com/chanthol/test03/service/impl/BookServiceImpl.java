package com.chanthol.test03.service.impl;

import com.chanthol.test03.models.Book;
import com.chanthol.test03.repository.BookRepositories;
import com.chanthol.test03.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookRepositories bookRepositories;

    @Autowired
    public BookServiceImpl(BookRepositories bookRepositories){
        this.bookRepositories=bookRepositories;
    }

    @Override
    public List<Book> getAll() {
        return this.bookRepositories.getAll();
    }

    @Override
    public Book viewOne(Integer id) {
        return this.bookRepositories.viewOne(id);
    }

    @Override
    public boolean update(Book book) {
        return this.bookRepositories.update(book);
    }

    @Override
    public boolean delete(Integer id) {
        return this.bookRepositories.delete(id);
    }

    @Override
    public boolean create(Book book) {
        return this.bookRepositories.create(book);
    }
}
