package by.telecom.subapp.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
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
	private static final Logger logger = Logger.getLogger(LogService.class);

	@Transactional
	public List<Log> getByParameter(String user, Date dateStart, Date dateEnd, String type, String comment) {
		String sort = "date";
		String orderType = "asc";
		if (user == null && type == null && comment == null) {
			user = "";
			type = "";
			comment = "";
		}
		return logDao.getByParameter(user, dateStart, dateEnd, type, comment, sort, orderType);
	}

	@Transactional
	public Long create(String user, String type, String comment) {
		Log newLog = new Log();
		newLog.setUser(user);
		newLog.setDate(new Date());
		newLog.setType(type);
		newLog.setComment(comment);
		logger.info("SERVICE - create Log");
		return logDao.create(newLog);
	}

	@Transactional
	public List<Log> getAll() {
		return logDao.getAll(Log.class, "user", "asc");
	}

}
