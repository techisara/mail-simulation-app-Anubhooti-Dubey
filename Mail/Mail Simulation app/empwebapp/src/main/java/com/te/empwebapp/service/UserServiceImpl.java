package com.te.empwebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.empwebapp.beans.User;

import com.te.empwebapp.dao.UserDAO;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO dao;

	@Override
	public User authenticate(String email, String pwd) {
		if (email == null) {
			return null;
		} else {
			return dao.authenticate(email, pwd);
		}
	}

	@Override
	public User getEmployeeData(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteEmpData(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addEmployee(User user) {
		// TODO Auto-generated method stub
		return dao.addEmployee(user);
	}

	@Override
	public boolean updateRecord(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
