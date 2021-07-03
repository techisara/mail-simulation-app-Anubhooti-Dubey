package com.te.empwebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.empwebapp.beans.Mail;
import com.te.empwebapp.beans.User;
import com.te.empwebapp.dao.MailDao;
import com.te.empwebapp.dao.UserDAO;
@Service
public class MailServiceImpl implements MailService{
	
	MailDao dao;

	@Override
	public User authenticate(String email, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mail getEmployeeData(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteEmpData(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addEmployee(Mail mail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRecord(Mail mail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Mail> getAllEmployees() {
		// TODO Auto-generated method stub
		return dao.getAllEmployees();
	}
	
	
}
