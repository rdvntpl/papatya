package com.horizon.fps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.horizon.fps.Model.Product;
import com.horizon.fps.db.ProductDB;
import com.horizon.fps.db.UserDB;

@Controller
@RequestMapping(value = "/manager/")
public class ManagerController {
	ProductDB productService = new ProductDB();
	UserDB userService = new UserDB();
	
	@RequestMapping(value = "/")
	public ModelAndView index() {

		return new ModelAndView("manager/index");
	}
	
	@RequestMapping(value = "/products")
	public ModelAndView products() {


		return new ModelAndView("manager/products","products",productService.selectAllFromDB());
	}
	
	@RequestMapping(value = "/products/add" , method = RequestMethod.GET)
	public ModelAndView productAdd(@ModelAttribute Product product) {
		
		System.out.println(product.getId()+" "+product.getName()+" "+product.getPrice());

		return new ModelAndView("manager/products","products",productService.selectAllFromDB());
	}
	
	@RequestMapping(value = "/users" , method = RequestMethod.GET)
	public ModelAndView users() {


		return new ModelAndView("manager/users","users",userService.selectAllFromDB());
	}
}
