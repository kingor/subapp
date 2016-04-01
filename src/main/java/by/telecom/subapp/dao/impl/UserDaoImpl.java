package by.telecom.subapp.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.telecom.subapp.dao.UserDao;
import by.telecom.subapp.model.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	private static final Logger logger = Logger.getLogger(UserDao.class);

	public User getByLogin(String login) {
		logger.info("Get USER by login = " + login);
		Session session = null;
		List<User> all = null;

		session = sessionFactory.getCurrentSession();
		all = session.createCriteria(User.class).add(Restrictions.like("login", "%" + login + "%")).list();

		if (all.size() > 0) {
			return all.get(0);
		} else {
			return null;
		}

	}

	public List<User> getByParameter(String login, String name, Integer category, String sort, String orderType) {
		logger.info("Get USER by sort = " + sort + " order = " + orderType);

		Session session = null;
		List<User> userList = null;

		session = sessionFactory.getCurrentSession();
		userList = session.createCriteria(User.class).add(Restrictions.like("login", "%" + login + "%"))
				.add(Restrictions.like("name", "%" + name + "%")).list();

		return userList;// all;
	}

}
