package by.telecom.subapp.service;

import java.util.List;

import by.telecom.subapp.model.Subscriber;
import by.telecom.subapp.model.User;

public interface UserService {
public List getAll(Class<User> clazz, String sort, String orderType);
	
    Long create(User user);
    
    User read(Class<User> classT, Long id);

    void update(User user);

    void delete(User user);

	public List<User> getByParameter(String login, String name, Integer category, String sort, String orderType);
}
