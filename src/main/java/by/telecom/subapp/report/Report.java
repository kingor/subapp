package by.telecom.subapp.report;

import java.util.List;

public interface Report<T> {

	void create(String pathForSaving, String pathForPattern, List<T> dataList);
}
