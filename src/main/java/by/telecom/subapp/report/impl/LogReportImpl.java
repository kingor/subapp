package by.telecom.subapp.report.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import by.telecom.subapp.model.Log;
import by.telecom.subapp.report.LogReport;

@Component
public class LogReportImpl extends GenericReport<Log> implements LogReport {

	@Override
	public void create(String pathForSaving, String pathForPattern, List<Log> dataList, Map<String, Object> parameters) {
		super.create(pathForSaving, pathForPattern, dataList, parameters);
	}

}
