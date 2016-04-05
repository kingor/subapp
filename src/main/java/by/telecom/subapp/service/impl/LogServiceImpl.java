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
	public List<Log> getByParameter(String user, Date dateBegin, Date dateEnd, String type, String comment, String sort, String orderType) {
		return logDao.getByParameter(user, dateBegin, dateEnd, type, comment, sort, orderType);
	}

	@Transactional
	public Long create(String user, String type, String comment) {
		Log newLog = new Log();
		newLog.setUser(user);
		newLog.setDate(new Date());
		newLog.setType(type);
		newLog.setComment(comment);
		return logDao.create(newLog);
	}

}
