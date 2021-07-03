package com.te.empwebapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.te.empwebapp.beans.User;
import com.te.empwebapp.customexp.EmployeeException;
@Repository
public class UserDAOImplimentation  implements UserDAO{
	@PersistenceUnit
	private EntityManagerFactory factory;
	
	@Override
	public User authenticate(String email, String pwd) {
		EntityManager manager = factory.createEntityManager();
		User user = manager.find(User.class,email);

		if (user != null) {
			if (user.getPassword().equals(pwd)) {
				return user;
			} else {
				throw new EmployeeException("Password is wrong");
			}
		} else {
			throw new EmployeeException("Invalid ID");
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
		boolean isInserted = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			manager.persist(user);
			transaction.commit();
			isInserted = true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

		return isInserted;
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
