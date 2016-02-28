package org.josescalia.blog.simple.controller;

import org.apache.log4j.Logger;
import org.josescalia.blog.simple.model.Author;
import org.josescalia.blog.simple.model.Book;
import org.josescalia.blog.simple.model.Publisher;
import org.josescalia.blog.simple.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by josescalia on 03/02/16.
 */
@Controller
public class BookController {

    static Logger logger = Logger.getLogger(BookController.class.getName());

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "/service/json/book/list", method = RequestMethod.GET)
    public @ResponseBody List<Book> getBookList(){
        return (List<Book>) bookRepository.findAll();
    }

    @RequestMapping(value = "/book/list", method = RequestMethod.GET)
    public String getBookList(Map<String,Object> objectMap){
        Publisher publisher = new Publisher();
        Author author = new Author();
        Book book = new Book();
        book.setPublisher(publisher);
        book.setAuthor(author);
        objectMap.put("model", book);
        objectMap.put("bookList", bookRepository.findAll());
        return "book/list";
    }

    @RequestMapping(value = "/book/edit", method = RequestMethod.GET)
    public String edit(@RequestParam Long id, Map<String, Object> objectMap) {
        Book book = bookRepository.findOne(id);
        objectMap.put("model", book);
        return "/book/edit";


    }


    @RequestMapping(value = "/service/json/book/save", method = RequestMethod.POST)
    public @ResponseBody String saveBook(Book book) {
        try {
            bookRepository.save(book);
            return "Save Succeed";
        } catch (Exception e) {
            logger.error(e.getMessage());
            return "Save Failed : " + e.getMessage();
        }
    }
}
