package by.telecom.subapp.dao;

import java.util.Date;
import java.util.List;

import by.telecom.subapp.model.Log;

public interface LogDao extends GenericDao<Log, Long> {

	List<Log> getByParameter(String user, Date dateBegin, Date dateEnd, String type,
			String comment, String sort, String orderType);

}
