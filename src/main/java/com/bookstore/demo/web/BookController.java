package com.bookstore.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.qos.logback.core.model.Model;

@Controller
@ResponseBody
public class BookController {
	
	@GetMapping("/index")
	public String index(Model model) {
		return "This is the main index";
	}
}