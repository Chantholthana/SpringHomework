package com.chanthol.test03.controllers;

import com.chanthol.test03.models.Book;
import com.chanthol.test03.service.BookService;
import com.chanthol.test03.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebParam;
import javax.naming.Binding;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Controller
public class BookController {
    private BookService bookService;

    @Autowired
    private UploadService uploadService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService=bookService;
    }

    @GetMapping("/index")
    public String index(Model model){
        List<Book> bookList=this.bookService.getAll();
          model.addAttribute("books",bookList);
        return "book/index";
    }

    @GetMapping("/view/{id}")
    public String viewOne(@PathVariable("id") Integer id,Model model){
        System.out.printf("ID: "+id);
        Book book=this.bookService.viewOne(id);
        model.addAttribute("book",book);
        return "book/view";
    }

    @GetMapping("/update/{book_id}")
    public String showFrmUpdate(@PathVariable Integer book_id,Model model){
        System.out.printf("Id update: "+book_id);
        Book book=this.bookService.viewOne(book_id);

        model.addAttribute("isNew",false);
        model.addAttribute("book",book);
        return "book/create_book";
    }

    @PostMapping("update/submit")
    public String updatSubmit(@ModelAttribute("book") Book book,MultipartFile file){
        System.out.println(book);
        String filename=this.uploadService.singleFileUploadFile(file,"class/");
        if (!file.isEmpty()){
            book.setThumbnail("/images-btb"+filename);
        }

        this.bookService.update(book);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        System.out.println(id);
        this.bookService.delete(id);
        return "redirect:/index";
    }


    @GetMapping("/create")
    public String create(Model model){

        model.addAttribute("isNew",true);
        model.addAttribute("book",new Book());
        return "book/create_book";
    }


    @PostMapping("/create/submit")
    public String create(@Valid Book book, BindingResult bindingResult, MultipartFile file){
        String filename=this.uploadService.upload(file,"/class/");
        book.setThumbnail("/images-btb/"+filename);

        if (bindingResult.hasErrors()){
            return "book/create_book";
        }

        System.out.println(book);
        this.bookService.create(book);
        return "redirect:/index";
    }


    @GetMapping("/test-multi-upload")
    public String showUpload(){
        return "book/upload_file";
    }

    @PostMapping("/test-multi-upload/submit")
    public String testMultipleFileUpload(@RequestParam("file") List<MultipartFile> files){
//        files.forEach(file -> {
//            System.out.println(file.getOriginalFilename());
//        });
        List<String> filename=this.uploadService.upload(files,"test/");
        return "";
    }




}

