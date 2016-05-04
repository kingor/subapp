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
import javax.validation.constraints.Size;

@Entity
public class Subscriber implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	@Size(min = 3, max = 25, message = "Имя должно быть от 3 до 25 символов")
	private String name;
	@Size(min = 3, max = 50, message = "Адрес должен быть от 3 до 50 символов")
	private String address;
	private String comment;

	public Subscriber() {

	}

	public Subscriber(Long id, String name, String address, String comment) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.comment = comment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long aId) {
		id = aId;
	}

	public String getName() {
		return name;
	}

	public void setName(String aName) {
		name = aName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String aAddress) {
		address = aAddress;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String aComment) {
		comment = aComment;
	}

	@Override
	public String toString() {
		String subscriberData = "";
		return subscriberData.concat("id: ").concat(String.valueOf(id)).concat(" --- ФИО: ").concat(name).concat(" --- Адрес: ").concat(address)
				.concat(" --- Примечание: ").concat(comment);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscriber other = (Subscriber) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
