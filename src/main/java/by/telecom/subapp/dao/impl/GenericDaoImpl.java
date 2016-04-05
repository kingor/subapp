package by.telecom.subapp.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.telecom.subapp.dao.GenericDao;

/**
 *
 * @param <T>
 *            Entity class
 * @param <PK>
 *            primary key of entity
 */
@Repository
public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

	@Autowired
	private SessionFactory sessionFactory;
	private static final Logger logger = Logger.getLogger(GenericDao.class);

	public List<T> getAll(Class<T> classT, String sort, String orderType) {
		logger.info("DAO - caused getAll() with sort = " + sort + " order = " + orderType);
		Session session = null;
		List<T> all = null;
		session = sessionFactory.getCurrentSession();

		Order order = Order.asc(sort);
		if (orderType.equals("desc"))
			order = Order.desc(sort);
		all = session.createCriteria(classT).addOrder(order).list();
		return all;
	}

	public PK create(T newInstance) {
		logger.info("DAO - caused create()");
		Session session = sessionFactory.getCurrentSession();
		return (PK) session.save(newInstance);
	}

	public T read(Class<T> classT, PK id) {
		logger.info("DAO - caused read() with id = " + id);
		Session session = sessionFactory.getCurrentSession();
		T objectT = (T) session.createCriteria(classT).add(Restrictions.eq("id", id)).uniqueResult();
		return objectT;
	}

	public void update(T transientObject) {
		logger.info("DAO - caused update()");
		Session session = sessionFactory.getCurrentSession();
		session.update(transientObject);
	}

	public void delete(T persistentObject) {
		logger.info("DAO - caused delete()");
		Session session = sessionFactory.getCurrentSession();
		session.delete(persistentObject);
	}

}
