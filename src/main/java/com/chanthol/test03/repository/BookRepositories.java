package com.chanthol.test03.repository;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import com.chanthol.test03.models.Book;
import com.github.javafaker.Faker;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface BookRepositories {
    @Select("select * from tb_book")
    List<Book> getAll();

    @Select("select * from tb_book where id=#{id}")
    Book viewOne(@Param(("id")) Integer id);

    @Update("update tb_book set title=#{title}, author=#{author},publisher=#{publisher},thumbnail=#{thumbnail} where id=#{id}")
    boolean update(Book book);

    @Delete("DELETE * FROM tb_book where id=#{id}")
    boolean delete(Integer id);

    @Insert("insert into tb_book(title,author,publisher,thumbnail) values(#{title},#{author},#{author},#{publisher},#{thumbnail} )")
    boolean create(Book book);

//    Faker faker=new Faker();
//    List<Book> bookList=new ArrayList<>();
//    {
//        for (int i=0;i<=10;i++){
//            Book book=new Book();
//            book.setId(i);
//            book.setTitle(faker.book().title());
//            book.setAuthor(faker.book().author());
//            book.setPublisher(faker.book().publisher());
//            bookList.add(book);
//        }
//    }
//    public List<Book> getAll(){
//        return this.bookList;
//    }
//
//    public Book viewOne(Integer id){
//        for(int i=0;i<bookList.size();i++){
//            if(bookList.get(i).getId()==id){
//                return bookList.get(i);
//            }
//        }
//        return null;
//    }
//
//    public boolean update(Book book){
//        for(int i=0;i<bookList.size();i++){
//            if(bookList.get(i).getId()==book.getId()){
//                bookList.set(i,book);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean delete(Integer id){
//        for(int i=0;i<bookList.size();i++){
//            if(bookList.get(i).getId()==id){
//                bookList.remove(i);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean create(Book book){
//        return bookList.add(book);
//    }


}
