package com.example.demo.web;

import java.io.IOException;
import java.nio.file.Path;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("product")
public class ProductController {
    private Log logger = LogFactory.getLog(getClass());

    @Autowired
    private ProductService productService;

    @ModelAttribute(name="productForm")
	ProductForm setUpForm() {
		return new ProductForm();
	}
	
	@PostMapping("input")
	public ModelAndView input(ModelAndView mav, @ModelAttribute ProductForm form) {
		mav.setViewName("product/input");
		mav.addObject("tagMap", productService.createTagMap());
		return mav;
	}

	@PostMapping("confirm")
	public ModelAndView confirm(ModelAndView mav, @ModelAttribute ProductForm form, BindingResult result) {
		// アップロードファイル名の退避
	    form.setImageFileName(form.getImageFile().getOriginalFilename());
		// アップロードファイルの退避
		try {
            Path savedFilePath = productService.saveUploadedFileTemporary(form.getImageFile());
            form.setSavedImageFilePath(savedFilePath.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
		// セレクトボックスで選択された項目の名称を退避
		productService.completeTagNames(form);
		mav.setViewName("product/confirm");
		return mav;
	}

	@PostMapping("update")
	public String update(ModelAndView mav, @ModelAttribute ProductForm form, BindingResult result) {
	    logger.info(form.toString());
		// DBに登録する
	    productService.saveProduct(form);
		return "redirect:/product/complete";
	}

	@GetMapping("complete")
	public String complete() {
		return "product/complete";
	}

}
