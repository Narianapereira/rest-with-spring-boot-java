package br.com.erudio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.erudio.model.Book;
import br.com.erudio.model.Person;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
