package by.telecom.subapp.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.telecom.subapp.dao.PhoneDao;
import by.telecom.subapp.model.Phone;
import by.telecom.subapp.model.Subscriber;

@Repository
public class PhoneDaoImpl implements PhoneDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Phone> getBySubscriber(Subscriber subscriber) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Phone> getAll() {
		List<Phone> list = (List<Phone>) sessionFactory.getCurrentSession().createQuery("from Phone").list();
		return list;
	}

}
