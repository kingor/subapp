package by.telecom.subapp.service.impl;

import java.util.List;

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
	
	@Transactional
	public List getAll(Class<User> clazz, String sort, String orderType) {
		return userDao.getAll(User.class, sort, orderType);
	}

	@Transactional
	public List<User> getByParameter(String login, String name, Integer category, 
			String sort, String orderType) {
		return userDao.getByParameter(login, name, category, sort, orderType);
	}
	
	@Transactional
	public Long create(User newInstanse) {
		return userDao.create(newInstanse);
	}
	
	@Transactional
	public User read(Class<User> classT, Long id) {
		// TODO Auto-generated method stub
		return userDao.read(classT, id);
	}
	
	@Transactional
	public void update(User transientObject) {
		userDao.update(transientObject);
		
	}
	
	@Transactional
	public void delete(User persistentObject) {
		userDao.delete(persistentObject);
		
	}


}
