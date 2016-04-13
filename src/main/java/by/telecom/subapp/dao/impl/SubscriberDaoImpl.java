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

	@SuppressWarnings("unchecked")
	public List<Subscriber> getByParameter(String name, String address, String comment, String sort, String orderType) {
		logger.info("DAO - get Subscriber by parameter sort = " + name + " order = " + orderType);
		Session session = sessionFactory.getCurrentSession();
		Order order = Order.asc(sort);
		if (orderType.equals("desc"))
			order = Order.desc(sort);

		List<Subscriber> listSuscrtiber = (List<Subscriber>) session.createCriteria(Subscriber.class)
				.add(Restrictions.like("name", "%" + name + "%")).add(Restrictions.like("address", "%" + address + "%"))
				.add(Restrictions.like("comment", "%" + comment + "%")).addOrder(order).list();
		return listSuscrtiber;
	}

}
