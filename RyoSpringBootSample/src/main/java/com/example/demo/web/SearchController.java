package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {

	@ModelAttribute(name="searchForm")
	SearchForm setUpForm() {
		return new SearchForm();
	}
	
	@GetMapping(value = {"/", "index"})
	public String index() {
		return "index";
	}
	
	@GetMapping("search/condition")
	public ModelAndView condition(ModelAndView mav, @ModelAttribute SearchForm searchForm) {
		mav.setViewName("search/condition");
		return mav;
	}
	
	@PostMapping("search/search")
	public ModelAndView search(ModelAndView mav, @ModelAttribute SearchForm searchForm) {
		mav.addObject("url", "/images/ion.jpg");
		mav.setViewName("search/list");
		return mav;
	}
}
