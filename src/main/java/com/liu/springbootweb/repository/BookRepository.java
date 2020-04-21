package com.liu.springbootweb.repository;

import com.liu.springbootweb.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book, Integer> {

    List<Book> findBookByAuthorLike(String author);

}
