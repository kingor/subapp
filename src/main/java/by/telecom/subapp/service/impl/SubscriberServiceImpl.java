package by.telecom.subapp.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
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
	
	private static final Logger logger = Logger.getLogger(SubscriberService.class);
	
	@Transactional
	public List getAll(Class<Subscriber> clazz, String sort, String orderType) {
		logger.info("SubscriberService Get all subscriber!");
		return subscriberDao.getAll(Subscriber.class, sort, orderType);
	}

	@Transactional
	public List<Subscriber> getByParameter(String name, String address,
			String comment, String sort, String orderType) {
		logger.info("SubscriberService Get all subscriber with parameter!");
		return subscriberDao.getByParameter(name, address, comment, sort, orderType);
	}
	
	@Transactional
	public Long create(Subscriber newInstanse) {
		logger.info("create");
		return subscriberDao.create(newInstanse);
	}
	
	@Transactional
	public Subscriber read(Class<Subscriber> classT, Long id) {
		logger.info("read");
		return subscriberDao.read(classT, id);
	}
	
	@Transactional
	public void update(Subscriber transientObject) {
		logger.info("update");
		subscriberDao.update(transientObject);
		
	}
	
	@Transactional
	public void delete(Subscriber persistentObject) {
		logger.info("delete");
		subscriberDao.delete(persistentObject);
		
	}

}
