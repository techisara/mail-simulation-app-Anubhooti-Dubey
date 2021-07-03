package com.te.empwebapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.te.empwebapp.beans.Mail;
import com.te.empwebapp.beans.User;
public interface MailService {
	public User authenticate(String email, String pwd);

	public Mail getEmployeeData(int id);

	public boolean deleteEmpData(int id);

	public boolean addEmployee(Mail mail);

	public boolean updateRecord(Mail mail);

	public List<Mail> getAllEmployees();
}
