package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HelloController {
	
	@Autowired
	EmployeesService empService;
	
	@GetMapping("/")
	public String hello() {
		return "<html><body><h1>Hello World</h1></body></html>";
	}
}
