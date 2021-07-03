package com.te.empwebapp.dao;

import java.util.List;

import com.te.empwebapp.beans.Mail;
import com.te.empwebapp.beans.User;

public interface MailDao {
	public Mail authenticate(int id, String pwd);

	public User getEmployeeData(int id);

	public boolean deleteEmpData(int id);

	public boolean addEmployee(Mail mail);

	public boolean updateRecord(Mail mail);

	public List<Mail> getAllEmployees();
}
