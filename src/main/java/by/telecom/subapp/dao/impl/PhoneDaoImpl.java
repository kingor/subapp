package by.telecom.subapp.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.telecom.subapp.dao.PhoneDao;
import by.telecom.subapp.model.Phone;
import by.telecom.subapp.model.Subscriber;

@Repository
public class PhoneDaoImpl extends GenericDaoImpl<Phone, Long> implements PhoneDao {

	@Autowired
	private SessionFactory sessionFactory;
	private static final Logger logger = Logger.getLogger(PhoneDao.class);

	public List<Phone> getBySubscriber(Subscriber subscriber) {

		logger.info("DAO - get PHONE by Subscriber " + subscriber.getName());
		Session session = sessionFactory.getCurrentSession();
		List<Phone> phones = session.createCriteria(Phone.class).add(Restrictions.eq("subscriber", subscriber)).list();
		return phones;
	}

	public List<Phone> getByParameter(String number, String band, String security, String scv, String adsl, String name, String sort, String orderType) {

		logger.info("DAO - get PHONE by parameter sort = " + sort + " order = " + orderType);
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Phone.class).add(Restrictions.like("number", number + "%"))
				.add(Restrictions.like("band", band + "%")).add(Restrictions.like("security", security + "%"))
				.add(Restrictions.like("scv", scv + "%")).add(Restrictions.like("adsl", adsl + "%"));
		Order order = Order.asc(sort);
		if (orderType.equals("desc"))
			order = Order.desc(sort);
		if (sort.equals("name"))
			criteria = criteria.createCriteria("subscriber").add(Restrictions.like("name", "%" + name + "%")).addOrder(order);
		else
			criteria = criteria.addOrder(order).createCriteria("subscriber").add(Restrictions.like("name", "%" + name + "%"));

		List<Phone> phones = criteria.list();
		return phones;
	}

}
