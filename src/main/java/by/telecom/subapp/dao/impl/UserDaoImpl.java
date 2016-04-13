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

	@SuppressWarnings("unchecked")
	public User getByLogin(String login) {
		logger.info("DAO - get USER by login = " + login);

		Session session = sessionFactory.getCurrentSession();
		List<User> userList = (List<User>) session.createCriteria(User.class).add(Restrictions.like("login", "%" + login + "%")).list();

		if (userList.size() > 0) {
			return userList.get(0);
		} else {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public List<User> getByParameter(String login, String name, Integer category, String sort, String orderType) {
		logger.info("DAO - get USER by sort = " + sort + " order = " + orderType);

		Session session = sessionFactory.getCurrentSession();
		List<User> userList = (List<User>) session.createCriteria(User.class).add(Restrictions.like("login", "%" + login + "%"))
				.add(Restrictions.like("name", "%" + name + "%")).list();

		return userList;
	}

}
