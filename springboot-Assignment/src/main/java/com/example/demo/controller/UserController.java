package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserPage;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	
//	Build A Api To Save The Student
//	http://localhost:8080/api/student
	@PostMapping("/api/student")
	public ResponseEntity<UserPage> saveStudent(@RequestBody  UserPage page)
	{
		return new ResponseEntity<UserPage>(service.saveStudent(page),HttpStatus.CREATED);
	}
	
//	Build Api To Get The Student By StudentId
//	http://localhost:8080/api/student/{studentid}
	@GetMapping("/api/student/{studentid}")
	public ResponseEntity<UserPage> getStudentById(@PathVariable long studentid)
	{
		Optional<UserPage> optional=service.getStudentById(studentid);
		return optional.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
	}
	
//	Build Api To Update The Student Information
//	http://localhost:8080/api/student/{studentid}
	@PutMapping("/api/student/{studentid}")
	public ResponseEntity<UserPage> updateStudent(@RequestBody  UserPage page,@PathVariable  long studentid)
	{
		return new ResponseEntity<UserPage>(service.updateStudent(page, studentid),HttpStatus.OK);
	}
	
//	Build Api To Delete Student From Database
//	http://localhost:8080/api/student/{studentid}
	@DeleteMapping("/api/student/{studentid}")
	public ResponseEntity<String> deleteStudent(@PathVariable  long studentid)
	{
		service.deleteStudent(studentid);
		return new ResponseEntity<String>("Student Deleted From Database",HttpStatus.OK);
	}	
}
