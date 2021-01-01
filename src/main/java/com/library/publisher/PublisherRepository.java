package com.library.publisher;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;




public interface PublisherRepository extends JpaRepository<Publisher, Integer>{
	@Query(nativeQuery=true,value="select * from publisher p where p.publisher_name like %?1%")
	public List<Publisher> search(String keyword);
}
