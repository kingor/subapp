package by.telecom.subapp.dao;

import java.util.List;

import by.telecom.subapp.model.User;

public interface UserDao extends GenericDao<User, Long> {

	public User getByLogin(String login);

	public List<User> getByParameter(String login, String name, Integer category, String sort,
			String orderType);
}
