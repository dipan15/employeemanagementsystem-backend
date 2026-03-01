package com.example.demo;

import org.springframework.stereotype.Component;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empno;
	private String name;
	private String address;
	private String contact;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(int empno, String name, String address, String contact) {
		// TODO Auto-generated constructor stub
		this.empno = empno;
		this.name = name;
		this.address = address;
		this.contact = contact;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmpno() {
		return this.empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return this.contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "{empno:" + this.empno + ",name:" + this.name + ",address:"
	+ this.address + ",contact:" + this.contact + "}";
	}
	
//	{empno: 1, name: Dipan Tanna, address: Ahmedabad, contact: 7778923890}
}
