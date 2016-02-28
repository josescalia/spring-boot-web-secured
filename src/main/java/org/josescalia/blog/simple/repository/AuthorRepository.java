package org.josescalia.blog.simple.repository;

import org.josescalia.blog.simple.model.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by josescalia on 25/10/15.
 */
@Repository
public interface AuthorRepository extends PagingAndSortingRepository<Author,Long> {

    @Query(value = "SELECT a from Author a where a.authorName like %:searchText% or a.authorAddress like %:searchText% ")
    List<Author> findFiltered(@Param("searchText") String searchText);

    @Query(value = "SELECT a from Author a where a.authorName like %:searchText% or a.authorAddress like %:searchText%")
    Page<Author> getPaginatedList(@Param("searchText") String searchText, Pageable pageable);


}
