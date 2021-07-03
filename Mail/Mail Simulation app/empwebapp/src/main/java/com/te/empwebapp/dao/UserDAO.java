package com.te.empwebapp.dao;

import java.util.List;

import com.te.empwebapp.beans.User;

public interface UserDAO {

	public User authenticate(String email, String pwd);

	public User getEmployeeData(int id);

	public boolean deleteEmpData(int id);

	public boolean addEmployee(User user);

	public boolean updateRecord(User user);

	public List<User> getAllEmployees();
}
