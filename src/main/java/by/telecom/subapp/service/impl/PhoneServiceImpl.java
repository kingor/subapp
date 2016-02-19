package by.telecom.subapp.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.telecom.subapp.dao.PhoneDao;
import by.telecom.subapp.dao.SubscriberDao;
import by.telecom.subapp.model.Phone;
import by.telecom.subapp.model.Subscriber;
import by.telecom.subapp.service.PhoneService;
import by.telecom.subapp.service.SubscriberService;

@Service
public class PhoneServiceImpl implements PhoneService {
	
	@Autowired
	private PhoneDao phoneDao;
	private static final Logger logger = Logger.getLogger(PhoneService.class);
	
	@Transactional
	public List getAll(Class<Phone> clazz, String sort, String orderType) {
		logger.info("get all");
		return phoneDao.getAll(Phone.class, sort, orderType);
	}
	
	@Transactional
	public List getBySubscriber(Subscriber subscriber) {
		logger.info("get by subscriber");
		return phoneDao.getBySubscriber(subscriber);
	}

	@Transactional
	public List getByParameter(String number, String band, String security,
			String scv, String adsl, String name, String sort, String orderType) {
		logger.info("get by parameter");
		return phoneDao.getByParameter(number, band, security, scv, adsl, name, sort, orderType);
	}

	@Transactional
	public Long create(Phone newInstance) {
		logger.info("create");
		return phoneDao.create(newInstance);
	}

	@Transactional
	public Phone read(Class<Phone> classT, Long id) {
		logger.info("read");
		return phoneDao.read(classT, id);
	}

	@Transactional
	public void update(Phone phone) {
		logger.info("update");
		phoneDao.update(phone);		
	}

	@Transactional
	public void delete(Phone phone) {
		logger.info("dalete");
		phoneDao.delete(phone);
	}

}
