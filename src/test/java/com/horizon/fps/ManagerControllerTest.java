package com.horizon.fps;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

import com.horizon.fps.controller.ManagerController;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = ManagerController.class)
public class ManagerControllerTest {

	ManagerController home;
	
	@Mock
	MockMvc mock;
	
	@Before
	public void setup() throws Exception{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/view/");
        viewResolver.setSuffix(".jsp");
        
		mock = MockMvcBuilders.standaloneSetup(new ManagerController())
				.setViewResolvers(viewResolver)
				.build();
	}
		
	@Test
	public void managerIndexView() throws Exception{
		
		mock.perform(get("/manager/"))
		.andExpect(status().isOk())
		.andExpect(view().name("manager/index"));
	}

	@Test
	public void productsView() throws Exception{
	
		mock.perform(get("/manager/products"))
			.andExpect(status().isOk())
			.andExpect(view().name("manager/products"))
			.andExpect(model().attributeExists("products"));
	}
	
	@Test
	public void usersView() throws Exception{
		
		mock.perform(get("/manager/users"))
			.andExpect(status().isOk())
			.andExpect(view().name("manager/users"))
			.andExpect(model().attributeExists("users"));
	}
}
