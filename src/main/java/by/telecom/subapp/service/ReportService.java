package by.telecom.subapp.service;

import java.util.List;

public interface ReportService {

	<T> void create(String pathForSaving, String pathForPattern, List<T> dataList);
}
