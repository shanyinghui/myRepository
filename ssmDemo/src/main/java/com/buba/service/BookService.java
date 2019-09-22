package com.buba.service;

import java.util.List;
import java.util.Map;

import javax.xml.ws.handler.LogicalHandler;

import org.springframework.stereotype.Service;

import com.buba.pojo.Book;
import com.buba.pojo.Log;

public interface BookService {
	List<Book> findBook(Map parameterMap);

	int addBook(Book book);

	int udateBook(Book book);

	int deleteBook(Integer id);

	Integer findBookCount();
	
	void addLog(Log log);
}
