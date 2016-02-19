package by.telecom.subapp.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.telecom.subapp.dao.UserDao;
import by.telecom.subapp.model.Subscriber;
import by.telecom.subapp.model.User;
import by.telecom.subapp.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	private static final Logger logger = Logger.getLogger(UserService.class);
	
	@Transactional
	public List getAll(Class<User> clazz, String sort, String orderType) {
		logger.info("get all user!");
		return userDao.getAll(User.class, sort, orderType);
	}

	@Transactional
	public List<User> getByParameter(String login, String name, Integer category, 
			String sort, String orderType) {
		logger.info("get by parameter");
		return userDao.getByParameter(login, name, category, sort, orderType);
	}
	
	@Transactional
	public Long create(User newInstanse) {
		logger.info("create");
		return userDao.create(newInstanse);
	}
	
	@Transactional
	public User read(Class<User> classT, Long id) {
		logger.info("read");
		return userDao.read(classT, id);
	}
	
	@Transactional
	public void update(User transientObject) {
		logger.info("update");
		userDao.update(transientObject);
		
	}
	
	@Transactional
	public void delete(User persistentObject) {
		logger.info("delete");
		userDao.delete(persistentObject);
		
	}


}
