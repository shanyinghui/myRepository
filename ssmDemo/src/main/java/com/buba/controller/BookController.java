package com.buba.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buba.annotation.ArchivesLog;
import com.buba.pojo.Book;
import com.buba.service.BookService;
import com.buba.serviceImpl.BookServiceImpl;

@Controller
public class BookController {
	@Resource
	BookService bookServiceImpl;
	
	@RequestMapping("/toBook")
	public String toBook() {
		return "book";
	}
	
	@RequestMapping("/findBook")
	@ResponseBody
	public Map findBook(Integer page,Integer limit) {
		HashMap<String, Object> parameterMap = new HashMap();
		parameterMap.put("page", (page-1)*limit);
		parameterMap.put("pageNumber", limit);
		List<Book> books = bookServiceImpl.findBook(parameterMap);
		Integer count = bookServiceImpl.findBookCount();
		HashMap<String, Object> map = new HashMap();
		map.put("data", books);
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", count);
		return map;
	}
	

	@RequestMapping("/addBook")
	@ArchivesLog(operteContent="添加图书")
	public String addBook(Book book) {
		Integer id = book.getId();
		int n = id/0;
		System.out.println(id);
		if(id==0||id==null) {
			int i = bookServiceImpl.addBook(book);
		}else {
			int j = bookServiceImpl.udateBook(book);
		}
		
		return "redirect:toBook";		
	}
	
	@RequestMapping("/deleteBook")
	@ResponseBody
	@ArchivesLog(operteContent="删除图书")
	public Map deleteBook(Integer id) {
		int i = bookServiceImpl.deleteBook(id);
		HashMap<String, Object> map = new HashMap();
		if(i>0) {
			map.put("msg", "删除成功");
			return map;
		}
		map.put("msg", "删除失败");
		return map;
	}
}
