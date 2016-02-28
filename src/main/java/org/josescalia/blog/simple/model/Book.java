package org.josescalia.blog.simple.model;

import javax.persistence.*;

/**
 * Created by josescalia on 25/10/15.
 */
@Entity
@Table(name = "book")
public class Book {

    private Long id;
    private String bookTitle;
    private Author author;
    private Publisher publisher;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "BOOK_TITLE", length = 100, nullable = false)
    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }


    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID",nullable = false)
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @ManyToOne
    @JoinColumn(name = "PUBLISHER_ID",nullable = false)
    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookTitle='" + bookTitle + '\'' +
                ", author=" + author +
                ", publisher=" + publisher +
                '}';
    }
}
