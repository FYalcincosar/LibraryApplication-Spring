package com.library.author;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.library.book.Book;


public interface AuthorRepository extends JpaRepository<Author,Integer>{

	@Query(nativeQuery=true,value="select * from author a where a.author_name like %?1%")
	public List<Author> search(String keyword);
}
