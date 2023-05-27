package com.brian.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.brian.mvc.models.Book;
import com.brian.mvc.services.BookService;






@Controller
public class BookController {
	@Autowired
	BookService bookService;
	@GetMapping("/books/{id}")
	public String index(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute(book);
		return "show.jsp";
	}
	@GetMapping("/books")
	public String index2(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "index.jsp";
	}
	
}
