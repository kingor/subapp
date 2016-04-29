package by.telecom.subapp.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.telecom.subapp.dao.PhoneDao;
import by.telecom.subapp.model.Phone;
import by.telecom.subapp.model.Subscriber;
import by.telecom.subapp.service.PhoneService;

@Service
public class PhoneServiceImpl implements PhoneService {

	@Autowired
	private PhoneDao phoneDao;
	private static final Logger logger = Logger.getLogger(PhoneService.class);

	@Transactional
	public List<Phone> getAll(String sort, String orderType) {
		logger.info("SERVICE - get all Phones");
		if (!"band".equals(sort) && !"security".equals(sort) && !"scv".equals(sort) && !"adsl".equals(sort))
			sort = "number";
		if (!"asc".equals(orderType) && !"desc".equals(orderType))
			orderType = "asc";
		return phoneDao.getAll(Phone.class, sort, orderType);
	}

	@Transactional
	public List<Phone> getBySubscriber(Subscriber subscriber) {
		logger.info("SERVICE - get Phones by subscriber");
		return phoneDao.getBySubscriber(subscriber);
	}

	@Transactional
	public List<Phone> getByParameter(String number, String band, String security, String scv, String adsl, String name, String sort, String orderType) {
		logger.info("SERVICE - get Phones by parameter");
		if (!"band".equals(sort) && !"security".equals(sort) && !"scv".equals(sort) && !"adsl".equals(sort))
			sort = "number";
		if (!"asc".equals(orderType) && !"desc".equals(orderType))
			orderType = "asc";
		return phoneDao.getByParameter(number, band, security, scv, adsl, name, sort, orderType);
	}

	@Transactional
	public Long create(Phone newInstance) {
		logger.info("SERVICE - create Phone");
		return phoneDao.create(newInstance);
	}

	@Transactional
	public Phone read(Long id) {
		logger.info("SERVICE - read Phone with id " + id);
		return phoneDao.read(Phone.class, id);
	}

	@Transactional
	public void update(Phone transientObject) {
		logger.info("SERVICE - update Phone");
		phoneDao.update(transientObject);
	}

	@Transactional
	public void delete(Phone persistentObject) {
		logger.info("SERVICE - delete Phone");
		phoneDao.delete(persistentObject);
	}

	@Transactional
	public Long getCountRow() {
		logger.info("SERVICE - get count of Phone");
		Long count = phoneDao.getCountRow(Phone.class);
		return count;
	}

}
