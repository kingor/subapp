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
	
	@Transactional
	public Long create(Subscriber newInstanse) {
		return subscriberDao.create(newInstanse);
	}
	
	@Transactional
	public Subscriber read(Class<Subscriber> classT, Long id) {
		// TODO Auto-generated method stub
		return subscriberDao.read(classT, id);
	}
	
	@Transactional
	public void update(Subscriber transientObject) {
		subscriberDao.update(transientObject);
		
	}
	
	@Transactional
	public void delete(Subscriber persistentObject) {
		subscriberDao.delete(persistentObject);
		
	}

}
