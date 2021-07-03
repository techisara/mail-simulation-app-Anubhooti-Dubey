package com.te.empwebapp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.empwebapp.beans.EmployeeInfoBean;
import com.te.empwebapp.beans.Mail;
import com.te.empwebapp.beans.User;
@Repository
public class MailDAOImplimation implements MailDao  {
	@PersistenceUnit
	private EntityManagerFactory factory;
	@Override
	public Mail authenticate(int id, String pwd) {
		// TODO Auto-generated method stub
		return null;
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
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("from Mail");
		ArrayList<Mail> mails = new ArrayList<Mail>();
		try {
			mails = (ArrayList<Mail>) query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			mails = null;
		}

		return mails;
	}

	

}
