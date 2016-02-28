package org.josescalia.blog.simple.model;

import javax.persistence.*;

/**
 * Created by josescalia on 23/03/15.
 */
@Entity
@Table(name = "authorities",uniqueConstraints =@UniqueConstraint(columnNames = {"username","authority"}))
public class Authorities {
    private Long id;
    private User user;
    private String authority;



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", length = 30)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "username")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "authority", length = 30, nullable = false)
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }


    @Override
    public String toString() {
        return "Authorities{" +
                "user=" + user +
                ", authority='" + authority + '\'' +
                '}';
    }
}
