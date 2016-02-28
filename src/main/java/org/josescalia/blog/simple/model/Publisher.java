package org.josescalia.blog.simple.model;

import javax.persistence.*;

/**
 * Created by josescalia on 25/10/15.
 */
@Entity
@Table(name = "publisher")
public class Publisher {

    private Long id;
    private String publisherName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", length = 11)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "PUBLISHER_NAME", length = 100,nullable = false)
    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", publisherName='" + publisherName + '\'' +
                '}';
    }
}
