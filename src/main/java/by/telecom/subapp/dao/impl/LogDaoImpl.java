package by.telecom.subapp.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.telecom.subapp.dao.LogDao;
import by.telecom.subapp.model.Log;

@Repository
public class LogDaoImpl extends GenericDaoImpl<Log, Long> implements LogDao {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger logger = Logger.getLogger(LogDao.class);

	@SuppressWarnings("unchecked")
	public List<Log> getByParameter(String user, Date dateBegin, Date dateEnd, String type, String comment, String sort, String orderType) {
		logger.info("DAO - Log by Parameter sort = " + sort + " order = " + orderType);
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Log.class).add(Restrictions.ge("date", dateBegin)).add(Restrictions.le("date", dateEnd))
				.add(Restrictions.like("type", "%" + type + "%")).add(Restrictions.like("comment", "%" + comment + "%"))
				.add(Restrictions.like("user", "%" + user + "%"));
		Order order = Order.asc(sort);
		if (orderType.equals("desc"))
			order = Order.desc(sort);
		List<Log> logList = (List<Log>) criteria.addOrder(order).list();
		return logList;
	}

}
