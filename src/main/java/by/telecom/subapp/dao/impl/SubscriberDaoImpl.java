package by.telecom.subapp.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.telecom.subapp.dao.SubscriberDao;
import by.telecom.subapp.model.Subscriber;

@Repository
public class SubscriberDaoImpl extends GenericDaoImpl<Subscriber, Long> implements SubscriberDao {

	@Autowired
	private SessionFactory sessionFactory;
	private static final Logger logger = Logger.getLogger(SubscriberDao.class);

	public List<Subscriber> getByParameter(String name, String address, String comment,
			String sort, String orderType) {
		logger.info("Get by parameter sort = " + name + " order = " + orderType);
		Session session = null;
		List<Subscriber> all = null;

		session = sessionFactory.getCurrentSession();
		Order order = Order.asc(sort);
		if (orderType.equals("desc"))
			order = Order.desc(sort);
		System.out.println("!!!!!!!!DEBAG name" + name + " address" + address + " comment"
				+ comment);
		all = session.createCriteria(Subscriber.class)
				.add(Restrictions.like("name", "%" + name + "%"))
				.add(Restrictions.like("address", "%" + address + "%"))
				.add(Restrictions.like("comment", "%" + comment + "%")).addOrder(order).list();
		return all;
	}

}
