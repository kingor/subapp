package by.telecom.subapp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.telecom.subapp.dao.PhoneDao;
import by.telecom.subapp.dao.SubscriberDao;
import by.telecom.subapp.model.Phone;
import by.telecom.subapp.model.Subscriber;

@Repository
public class PhoneDaoImpl extends GenericDaoImpl<Phone, Long> implements PhoneDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Phone> getBySubscriber(Subscriber subscriber) {
		Session session = sessionFactory.getCurrentSession();
		List<Phone> phones = session.createCriteria(Phone.class)
                .add(Restrictions.eq("subscriber", subscriber)).list();
		return phones;
	}

}
