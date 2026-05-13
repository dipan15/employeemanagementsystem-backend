package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tools.jackson.databind.ObjectMapper;

import org.json.JSONObject;
import org.json.JSONArray;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class EmployeesController {
	
	@Autowired
	EmployeesService empService;
	
	@GetMapping("/home")
	public String home() {
		return "<html><body><h1>Employee Management System</h1><p>Welcome to Home Page</p></body></html>";
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
//		Employee e1 = new Employee(1, "Dipan Tanna", "Ahmedabad","7778923890");
//		Employee e2 = new Employee(2, "Devansh Thakkar", "Ahmedabad","7383494043");
//		List<Employee> employeesListStatic = new ArrayList<>(Arrays.asList(e1, e2));
		List<Employee> employeesList = empService.getEmployeesList();
		
//		JSONObject myjson1 = new JSONObject();
//		JSONArray array1 = new JSONArray();
//		json.put("course", array);
		
		System.out.println(employeesList);
		return employeesList;
	}
	
	@GetMapping("/employeesstring")
	public String getEmployeesString() {
		return empService.getEmployeesList().toString();
	}
	
	@GetMapping("/employees/{empNo}")
	public Employee getEmployeeByNo(@PathVariable int empNo) {
		return empService.getEmployeeByNo(empNo);
	}
	
	@PostMapping("/employees")
	public void addEmployee(@RequestBody Employee employee) {
		System.out.println("Here");
		empService.addEmployee(employee);
	}
	
	@PutMapping("/employees")
	public void updateEmployee(@RequestBody Employee employee) {
		empService.updateEmployee(employee);
	}
	
	@DeleteMapping("/employees/{empNo}")
	public void deleteEmployee(@PathVariable int empNo) {
		empService.deleteEmployee(empNo);
	}
}
