package com.Piyush.CrudApplication.repo;

import com.Piyush.CrudApplication.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Long>{


}
