package com.buba.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.buba.pojo.Book;
import com.buba.pojo.Log;

public interface BookMapper {
	
	List<Book> findBook(Map parameterMap);
	
	Integer findBookCount();

	int addBook(Book book);

	int updateBook(Book book);

	int deleteBook(Integer id);

	void addLog(Log log);
}
