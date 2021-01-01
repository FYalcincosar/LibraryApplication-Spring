package com.library.book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query(nativeQuery=true,value="select * from book b inner join author a on b.author_id = a.id inner join publisher p on b.publisher_id = p.id where CONCAT(b.book_title, ' ', b.book_series_name, ' ', b.isbn, ' ', b.book_subname, ' ', p.publisher_name, ' ',a.author_name) like %?1%")
	public List<Book> search(String keyword);

}
