/**
*
*
 
*
* Author : Shaik Fareed
*
* 
*
**/ 
package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.todo.TodoServiceApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TodoServiceApplication.class)
@WebAppConfiguration
public class HelloWorldApplicationTests {

	@Test
	public void contextLoads() {
	}

}
