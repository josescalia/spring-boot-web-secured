package org.josescalia.blog.simple.config;

import org.apache.log4j.Logger;
import org.josescalia.blog.simple.model.Author;
import org.josescalia.blog.simple.model.Book;
import org.josescalia.blog.simple.model.Publisher;
import org.josescalia.blog.simple.repository.AuthorRepository;
import org.josescalia.blog.simple.repository.BookRepository;
import org.josescalia.blog.simple.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by josescalia on 03/02/16.
 */
@Component
public class DataInitializer {
    static Logger logger = Logger.getLogger(DataInitializer.class.getName());

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PublisherRepository publisherRepository;


    @Autowired
    BookRepository bookRepository;

    @Autowired
    DatabaseConfig databaseConfig;

    @PostConstruct  //need to trigger this to fill up firstData
    public void initData(){
        logger.info("Init Data Invoked");


        /*harus di taro disini sebab spring-security akan menginisialiasi spring security lebih dahulu, baru kemudian mengeksekusi @PostConstruct untuk pengisian data*/
        JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();
        userDetailsService.setDataSource(databaseConfig.getDataSource());
        org.springframework.security.crypto.password.PasswordEncoder encoder = new BCryptPasswordEncoder();
        if(!userDetailsService.userExists("user")) {
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("USER"));
            UserDetails userDetails = new User("user", encoder.encode("password"), authorities);

            userDetailsService.createUser(userDetails);
        }

        if(!userDetailsService.userExists("administrator")){
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("USER"));
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
            UserDetails userDetails = new User("administrator",encoder.encode("admin123"),authorities);
            userDetailsService.createUser(userDetails);
        }



        /*Data Default Author and Publisher*/
        if(((List<Author>) authorRepository.findAll()).size() == 0) { //detect if no data on authorTable
            List<Author> authorList = new ArrayList<Author>();

            logger.info("No Data in table author");
            Author author = new Author();
            author.setAuthorName("Josescalia");
            author.setAuthorAddress("Jakarta");
            authorList.add(author);

            author = new Author();
            author.setAuthorName("Somebody");
            author.setAuthorAddress("Anywhere");
            authorList.add(author);

            authorRepository.save(authorList);

            Publisher publisher = new Publisher();
            publisher.setPublisherName("Gemah Ripah Loh Jinawi Press");
            publisher = publisherRepository.save(publisher);


            Book book = new Book();
            book.setAuthor(authorRepository.findOne((long)1));
            book.setBookTitle("Java 2nd Edition");
            book.setPublisher(publisher);
            bookRepository.save(book);



        }
    }
}
