package by.telecom.subapp.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.telecom.subapp.dao.LogDao;
import by.telecom.subapp.model.Log;
import by.telecom.subapp.service.LogService;

@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogDao logDao;

	@Transactional
	public List<Log> getByParameter(String name, Date dateBegin, Date dateEnd, String type,
			String comment, String sort, String orderType) {
		return logDao.getByParameter(name, dateBegin, dateEnd, type, comment, sort, orderType);
	}

}
