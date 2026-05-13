package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.LockModeType;
import jakarta.transaction.Transactional;
import tools.jackson.databind.ObjectMapper;

@Service
@Transactional
public class EmployeesService {
	
	@Autowired
	EmployeeRepository repo;
	
//	Employee e1 = new Employee(1, "Dipan Tanna", "Ahmedabad","7778923890");
//	Employee e2 = new Employee(2, "Devansh Thakkar", "Ahmedabad","7383494043");
//	ArrayList<Employee> employeesListStatic = new ArrayList<>(Arrays.asList(e1, e2));
	
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	public List<Employee> getEmployeesList() {
//		return employeesList;
		List<Employee> employeesList = repo.findAll();
//		employeesListStatic.forEach(System.out::println);
		return employeesList;
	}

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	public Employee getEmployeeByNo(int empNo) {
//		return employeesList.stream()
//				.filter(employee -> employee.getEmpno() == empNo)
//				.findFirst().get();
		return repo.findById(empNo).get();
	}
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	public void addEmployee(Employee employee) {
//		employeesList.add(employee);
		System.out.println("add employee result:");
		System.out.println(repo.save(employee));
	}
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	public void updateEmployee(Employee employee) {
//		int index = 0;
//		
//		for(int i=0; i<employeesList.size(); i++ ) {
//			if(employeesList.get(i).getEmpno() == employee.getEmpno()) {
//				index = i;
//			}
//		}
//		
//		employeesList.set(index, employee);
		repo.save(employee);
	}

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	public void deleteEmployee(int empNo) {
//		int index = 0;
//		
//		for(int i=0; i<employeesList.size(); i++ ) {
//			if(employeesList.get(i).getEmpno() == empNo) {
//				index = i;
//			}
//		}
//		
//		employeesList.remove(index);
		repo.deleteById(empNo);
	}
}
