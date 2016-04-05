package by.telecom.subapp.service;

import java.util.Date;
import java.util.List;

import by.telecom.subapp.model.Log;

public interface LogService {

	List<Log> getByParameter(String user, Date dateBegin, Date dateEnd, String type, String comment, String sort, String orderType);

	// Long create(String user, String message);
	Long create(String user, String type, String comment);

}
