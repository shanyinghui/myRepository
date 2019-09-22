package com.buba.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;

import com.buba.annotation.ArchivesLog;
import com.buba.mapper.BookMapper;
import com.buba.pojo.Book;
import com.buba.pojo.Log;
import com.buba.service.BookService;
@Service()
public class BookServiceImpl implements BookService{
	@Resource
	BookMapper bookMapper;
	
	@Override
	public List<Book> findBook(Map parameterMap) {
		return bookMapper.findBook(parameterMap);
	}
	
	
	@Override
	public int addBook(Book book) {
		
		return bookMapper.addBook(book);
	}

	@Override
	public int udateBook(Book book) {
		return bookMapper.updateBook(book);
	}

	@Override
	public int deleteBook(Integer id) {
		
		return bookMapper.deleteBook(id);
	}

	@Override
	public Integer findBookCount() {
		return bookMapper.findBookCount();
	}

	@Override
	public void addLog(Log log) {
		bookMapper.addLog(log);
	}

}
