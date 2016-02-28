package org.josescalia.blog.simple.repository;

import org.josescalia.blog.simple.model.Publisher;
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
public interface PublisherRepository extends PagingAndSortingRepository<Publisher, Long> {

    @Query("select a from Publisher a where a.publisherName like %:search%")
    List<Publisher> getList(@Param("search") String search);


    @Query("select a from Publisher a where a.publisherName like %:search%")
    Page<Publisher> getPaginatedList(@Param("search") String search, Pageable pageable);
}
