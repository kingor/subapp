package by.telecom.subapp.service;

import java.util.List;

import by.telecom.subapp.model.User;

public interface UserService extends GenericService<User> {

	public List<User> getByParameter(String login, String name, Integer category, String sort, String orderType);
}
