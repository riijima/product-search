package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("product")
public class ProductController {

	@ModelAttribute(name="productForm")
	ProductForm setUpForm() {
		return new ProductForm();
	}
	
	@PostMapping("input")
	public ModelAndView input(ModelAndView mav, @ModelAttribute ProductForm from) {
		System.out.println(from.getProductId());
		mav.setViewName("product/input");
		return mav;
	}

	@PostMapping("confirm")
	public ModelAndView confirm(ModelAndView mav, @ModelAttribute ProductForm from) {
		mav.setViewName("product/confirm");
		return mav;
	}

	@PostMapping("update")
	public String update(ModelAndView mav, @ModelAttribute ProductForm from) {
		//TODO DBに登録する
		return "redirect:/product/complete";
	}

	@GetMapping("complete")
	public String complete() {
		return "product/complete";
	}

}
