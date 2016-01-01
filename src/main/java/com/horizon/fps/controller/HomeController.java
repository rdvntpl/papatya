package com.horizon.fps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.horizon.fps.Model.User;
import com.horizon.fps.db.ProductDB;
import com.horizon.fps.db.UserDB;

@Controller
public class HomeController {
	ProductDB pService = new ProductDB();
	UserDB uService = new UserDB();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {

		ModelAndView home = new ModelAndView("home");
		home.addObject("products",pService.selectAllFromDB());
		home.addObject("user",new User());
		
		return home;
	}
	
	@RequestMapping(value = "/login",  method = RequestMethod.POST)
	public ModelAndView login(Model model, @ModelAttribute User user) {
		ModelAndView m = new ModelAndView("login");
		
		User respUser = uService.selectForLoginFromDB(user.getUsername(), user.getPassword());
		
		if (respUser == null) {
			m.addObject("message", "Hatalı Giriş");
		}else {
			m.addObject("user", respUser);
		}
		
		return m;
	}
	
	@RequestMapping(value = "/product/{id}")
	 public ModelAndView getProductById(@PathVariable int id)  
	 {  

		return new ModelAndView("home","product",pService.selectByIdFromDB(id));
	 }
	
}
