package com.horizon.fps;

import static org.junit.Assert.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.horizon.fps.controller.HomeController;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = HomeController.class)
public class HomeControllerTest {

	HomeController home;
	
	@Mock
	MockMvc mock;
	
	@Before
	public void setup() throws Exception{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/view/");
        viewResolver.setSuffix(".jsp");
        
		mock = MockMvcBuilders.standaloneSetup(new HomeController())
				.setViewResolvers(viewResolver)
				.build();
	}
		
	@Test
	public void mainView() throws Exception{
		
		mock.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(view().name("home"));
	}

	@Test
	public void loginPost() throws Exception{
	
		
		mock.perform(post("/login")
				.param("username", "admin")
				.param("password", "1234")
				.content("h2"))
			.andExpect(status().isOk());
	}
	
	@Test
	public void Database() throws Exception {
		    Class.forName("org.postgresql.Driver").newInstance();
		    
		    final String url = "jdbc:postgresql://ec2-107-21-125-143.compute-1.amazonaws.com:5432/d6d38dp6fnlb5u?"+
		    "user=nxomzfynxtfbwx&password=CTNlpUsfCT4DJj6ke7FpTkTHzK&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
		    
		    Connection connection = DriverManager.getConnection(url);
		    assertFalse(connection.isClosed());

		    connection.close();
		  }
		
}
