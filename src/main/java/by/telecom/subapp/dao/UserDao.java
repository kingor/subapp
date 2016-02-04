/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.telecom.subapp.dao;

import java.util.Collection;

import by.telecom.subapp.model.User;

import java.util.List;

/**
 *
 * @author ASUP8
 */
public interface UserDao {
	public List<User> getAll();
    public List<User> getByLogin(String login);
    public List<User> getByParameter(String login, String name, Integer category, String sort, String orderType);
}
