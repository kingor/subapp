package by.telecom.subapp.service;

import java.util.Date;
import java.util.List;

import by.telecom.subapp.model.Log;

public interface LogService {

	List<Log> getByParameter(String user, Date dateStart, Date dateEnd, String type, String comment);

	Long create(String user, String type, String comment);

}
