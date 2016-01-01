package com.horizon.fps.controller;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

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
		
		Socket conn;
		try {
			conn = new Socket("4865f12a.carbon.hostedgraphite.com", 2003);
			DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
			dos.writeBytes("9b917ef5-4391-4b5f-95a3-a1bf8f2c33f3.test.testing 1.2\n");
			conn.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("manager/index");
	}
	
	@RequestMapping(value = "/products")
	public ModelAndView products() {


		return new ModelAndView("manager/products","products",productService.selectAllFromDB());
	}
	
	@RequestMapping(value = "/products/add" , method = RequestMethod.POST)
	public ModelAndView productAdd(@ModelAttribute Product product) {
		
		System.out.println(product.getId()+" "+product.getName()+" "+product.getPrice());

		return new ModelAndView("manager/products","products",productService.selectAllFromDB());
	}
	
	@RequestMapping(value = "/users")
	public ModelAndView users() {


		return new ModelAndView("manager/users","users",userService.selectAllFromDB());
	}
}
