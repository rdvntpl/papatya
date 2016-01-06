package com.horizon.fps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.horizon.fps.Model.User;
import com.horizon.fps.db.ProductDB;
import com.horizon.fps.db.UserDB;

@Controller
public class HomeController {
	ProductDB pService = new ProductDB();
	UserDB uService = new UserDB();
	

	@RequestMapping(value = "/")
	public ModelAndView home() {
		
		ModelAndView home = new ModelAndView("home");
		home.addObject("products",pService.selectAllFromDB());
		home.addObject("user", null);

		return home;
	}
	
	@RequestMapping(value = "/register" , method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView home = new ModelAndView("register");
		home.addObject("user",new User());
		return home;
	}
	
	@RequestMapping(value = "/register" , method = RequestMethod.POST)
	public ModelAndView registered(@ModelAttribute("user") @Validated User user, BindingResult result,
			Model model, final RedirectAttributes rat) {
		ModelAndView home = new ModelAndView("register");

		
		return home;
	}
	
	@RequestMapping(value = "/login",  method = RequestMethod.POST)
	public ModelAndView login(Model model, @ModelAttribute("user") User user) {
		ModelAndView m = new ModelAndView("login");
		
		User respUser = uService.selectForLoginFromDB(user.getUsername(), user.getPassword());
		
		if (respUser == null) {
			m.addObject("message", "Hatalı Giriş");
		}else {
			m.addObject("user", respUser);
		}
		
		return m;
	}
	
	@RequestMapping(value = "/product/{id}",  method = RequestMethod.GET)
	 public ModelAndView getProductById(@PathVariable int id)  
	 {  

		return new ModelAndView("home","product",uService.selectByIdFromDB(id));
	 }
	
}
