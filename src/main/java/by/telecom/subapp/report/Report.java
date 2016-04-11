package by.telecom.subapp.report;

import java.util.List;
import java.util.Map;

public interface Report<T> {

	void create(String pathForSaving, String pathForPattern, List<T> dataList, Map<String, Object> parameters);
	// void setParameter()
}
