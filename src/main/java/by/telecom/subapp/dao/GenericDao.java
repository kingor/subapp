package by.telecom.subapp.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {

	PK create(T newInstance);

	T read(Class<T> classT, PK id);

	void update(T transientObject);

	void delete(T persistentObject);

	List<T> getAll(Class<T> classT, String sort, String orderType);

	Long getCountRow(Class<T> classT);

}
