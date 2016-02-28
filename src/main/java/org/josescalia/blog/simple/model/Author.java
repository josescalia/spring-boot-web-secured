package org.josescalia.blog.simple.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by josescalia on 25/10/15.
 */
@Entity
@Table(name = "author")
public class Author {
    private Long id;
    private String authorName;
    private String authorAddress;
    private Date createdDate;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", length = 11)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "AUTHOR_NAME", length = 100,nullable = false, unique = true)
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Column(name = "AUTHOR_ADDRESS", length = 255,nullable = true)
    public String getAuthorAddress() {
        return authorAddress;
    }

    public void setAuthorAddress(String authorAddress) {
        this.authorAddress = authorAddress;
    }

    @Column(name = "CREATED_DATE", nullable = true)
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", authorAddress='" + authorAddress + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
