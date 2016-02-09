package by.telecom.subapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.telecom.subapp.dao.SubscriberDao;
import by.telecom.subapp.model.Subscriber;
import by.telecom.subapp.model.User;
import by.telecom.subapp.service.SubscriberService;

@Service
public class SubscriberServiceImpl implements SubscriberService {
	
	@Autowired
	private SubscriberDao subscriberDao;
	
	@Transactional
	public List getAll(Class<Subscriber> clazz, String sort, String orderType) {
		return subscriberDao.getAll(Subscriber.class, sort, orderType);
	}

	@Transactional
	public List<Subscriber> getByParameter(String name, String address,
			String comment, String sort, String orderType) {
		return subscriberDao.getByParameter(name, address, comment, sort, orderType);
	}

	/*@Transactional
	public List<User> getByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public List<User> getByParameter(String login, String name,
			Integer category, String sort, String orderType) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	public void add(Student student) {
		studentDao.add(student);
	}

	@Transactional
	public void edit(Student student) {
		studentDao.edit(student);
	}

	@Transactional
	public void delete(int studentId) {
		studentDao.delete(studentId);
	}

	@Transactional
	public Student getStudent(int studentId) {
		return studentDao.getStudent(studentId);
	}

	@Transactional
	public List getAllStudent() {
		return studentDao.getAllStudent();
	}*/

}
