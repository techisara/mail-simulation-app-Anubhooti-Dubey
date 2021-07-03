package com.te.empwebapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.te.empwebapp.beans.User;
public interface UserService {
	public User authenticate(String email, String pwd);

	public User getEmployeeData(int id);

	public boolean deleteEmpData(int id);

	public boolean addEmployee(User user);

	public boolean updateRecord(User user);

	public List<User> getAllEmployees();
}
