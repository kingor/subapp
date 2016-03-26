package by.telecom.subapp.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.telecom.subapp.dao.SubscriberDao;
import by.telecom.subapp.model.Subscriber;
import by.telecom.subapp.service.SubscriberService;

@Service
public class SubscriberServiceImpl implements SubscriberService {

	@Autowired
	private SubscriberDao subscriberDao;

	private static final Logger logger = Logger.getLogger(SubscriberService.class);

	@Transactional
	public List<Subscriber> getAll(String sort, String orderType) {
		logger.info("SERVICE - getAll()");
		return subscriberDao.getAll(Subscriber.class, sort, orderType);
	}

	@Transactional
	public List<Subscriber> getByParameter(String name, String address, String comment,
			String sort, String orderType) {
		logger.info("SERVICE - getByParameter()");
		return subscriberDao.getByParameter(name, address, comment, sort, orderType);
	}

	@Transactional
	public Long create(Subscriber newInstanse) {
		logger.info("SERVICE - create()");
		return subscriberDao.create(newInstanse);
	}

	@Transactional
	public Subscriber read(Long id) {
		logger.info("SERVICE - read()");
		return subscriberDao.read(Subscriber.class, id);
	}

	@Transactional
	public void update(Subscriber transientObject) {
		logger.info("SERVICE - update()");
		subscriberDao.update(transientObject);

	}

	@Transactional
	public void delete(Subscriber persistentObject) {
		logger.info("SERVICE - delete()");
		subscriberDao.delete(persistentObject);

	}

}
