package org.josescalia.blog.simple.repository;

import org.josescalia.blog.simple.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by josescalia on 25/10/15.
 */
@Repository
public interface BookRepository extends CrudRepository<Book,Long>{

}
