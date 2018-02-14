package com.save;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.save.controller.HomeController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Save02ApplicationTests {
	
	@Autowired
	private HomeController homeController;

	@Test
	public void contextLoads() throws Exception{
		assertThat(homeController).isNotNull();
	}

}
