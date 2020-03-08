package com.whu.bookonline.controller;

import com.whu.bookonline.model.Book;
import com.whu.bookonline.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * \@RestController
 * 该注解用于代替@Controller和@ResponseBody
 * */
@Controller
public class BookController {
    @Resource
    BookService bookService;
//    // 返回Json时使用该注解
//    @ResponseBody
//    public List<Book> books() {
//        List<Book> books = new ArrayList<>();
//        Book b1 = new Book();
//        b1.setId(1);
//        b1.setName("book1");
//        b1.setAuthor("au1");
//        b1.setPrice(30f);
//        b1.setPublicationDate(new Date());
//        Book b2 = new Book();
//        b2.setId(2);
//        b2.setName("book2");
//        b2.setAuthor("au2");
//        b2.setPrice(30f);
//        b2.setPublicationDate(new Date());
//        books.add(b1);
//        books.add(b2);
////        ModelAndView mv = new ModelAndView();
////        mv.addObject("books", books);
////        mv.setViewName("books");
//        return books;
//    }

    @GetMapping("/ops")
    @ResponseBody
    public void ops() {
        Book b1 = new Book();
        b1.setName("西厢记");
        b1.setAuthor("王实甫");
        int i = bookService.addBook(b1);
        System.out.println("addBook>>>" + i);
        Book b2 = new Book();
        b2.setName("朝花夕拾");
        b2.setAuthor("鲁迅");
        int updateBook = bookService.updateBook(b2);
        System.out.println("updateBook>>>" + updateBook);
        Book b3 = bookService.getBookById(1);
        System.out.println("getBookById>>>" + b3);
        int delete = bookService.deleteBookById(2);
        System.out.println("deleteBookById>>>" + delete);
        List<Book> allBooks = bookService.getAllBooks();
        System.out.println("getAllBooks>>>" + allBooks);
    }

    @ResponseBody
    @PostMapping("/")
    public String addBook(String name) {
        return "receive:" + name;
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public String deleteBookById(@PathVariable Long id) {
        return String.valueOf(id);
    }
}
