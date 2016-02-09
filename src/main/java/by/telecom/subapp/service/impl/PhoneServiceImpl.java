package by.telecom.subapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.telecom.subapp.dao.PhoneDao;
import by.telecom.subapp.dao.SubscriberDao;
import by.telecom.subapp.service.PhoneService;
import by.telecom.subapp.service.SubscriberService;

@Service
public class PhoneServiceImpl implements PhoneService {
	
	@Autowired
	private PhoneDao phoneDao;
	
	@Transactional
	public List getAll() {
		return phoneDao.getAll();
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
