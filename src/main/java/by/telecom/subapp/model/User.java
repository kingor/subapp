/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.telecom.subapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private String login;

	private String password;

	private String name;

	private Integer category;

	public User() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long aId) {
		id = aId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String aLogin) {
		login = aLogin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String aPassword) {
		password = aPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String aName) {
		name = aName;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer aCategory) {
		category = aCategory;
	}

	@Override
	public String toString() {
		String userData = "";
		return userData.concat("id: ").concat(String.valueOf(id)).concat(" --- Логин: ").concat(login).concat(" --- Имя:").concat(name)
				.concat(" --- Категория").concat(String.valueOf(category));
	}

}
