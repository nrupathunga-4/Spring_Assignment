package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserPage;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public UserPage saveStudent(UserPage page)
	{
		return repository.save(page);
	}
	
	public Optional<UserPage> getStudentById(long studentid)
	{
		return repository.findById(studentid);
	}
	
	public UserPage updateStudent(UserPage page,long studentid)
	{
		UserPage page2=repository.findById(studentid).orElse(null);
		page2.setBranch(page.getBranch());
		page2.setStudentname(page.getStudentname());
		page2.setYearofjoining(page.getYearofjoining());
		page2.setQuery(page.getQuery());
		
		repository.save(page2);
		return page2;
	}
	
	public void deleteStudent(long studentid)
	{
		repository.findById(studentid);
		repository.deleteById(studentid);
	}
}
