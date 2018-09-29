package com.niit.smartphonebackend.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.smartphonebackend.model.Authorization;
import com.niit.smartphonebackend.model.Customer;
@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository
{

	@Autowired
	private SessionFactory sessionFactory;
	public boolean addCustomer(Customer customer) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.save(customer);
		Authorization auth=new Authorization();
		auth.setUserName(customer.getEmailId());
		session.save(auth);
		return false;
	}

}
