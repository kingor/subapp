package by.telecom.subapp.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.telecom.subapp.dao.UserDao;
import by.telecom.subapp.model.User;
import by.telecom.subapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	private static final Logger logger = Logger.getLogger(UserService.class);

	@Transactional
	public List<User> getAll(String sort, String orderType) {
		logger.info("SERVICE - get all Users");
		return userDao.getAll(User.class, sort, orderType);
	}

	@Transactional
	public List<User> getByParameter(String login, String name, Integer category, String sort, String orderType) {
		logger.info("SERVICE - get Users by parameters");
		if (!"name".equals(sort) && !"login".equals(sort))
			sort = "name";
		if (!"asc".equals(orderType) && !"desc".equals(orderType))
			orderType = "asc";

		if (name == null && login == null) {
			name = "";
			login = "";
		}
		return userDao.getByParameter(login, name, category, sort, orderType);
	}

	@Transactional
	public Long create(User newInstanse) {
		logger.info("SERVICE - create User");
		return userDao.create(newInstanse);
	}

	@Transactional
	public User read(Long id) {
		logger.info("SERVICE - read User with id " + id);
		return userDao.read(User.class, id);
	}

	@Transactional
	public void update(User transientObject) {
		logger.info("SERVICE - update User");
		userDao.update(transientObject);

	}

	@Transactional
	public void delete(User persistentObject) {
		logger.info("SERVICE - delete User");
		userDao.delete(persistentObject);

	}

	@Override
	@Transactional
	public Long getCountRow() {
		logger.info("SERVICE - get count of users");
		Long count = userDao.getCountRow(User.class);
		return count;
	}

}
