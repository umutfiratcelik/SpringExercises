package com.firat.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import com.firat.spring5webapp.domain.Book;

public interface BookRepository extends CrudRepository<Book,Long> {
}

