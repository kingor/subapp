package by.telecom.subapp.service;

import java.util.List;

public interface GenericService<T> {

	Long create(T newInstance);

	T read(Long id);

	void update(T transientObject);

	void delete(T persistentObject);

	List<T> getAll(String sort, String orderType);

	Long getCountRow();
}
