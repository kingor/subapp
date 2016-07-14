package by.telecom.subapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Phone implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_subscriber")
	// @Cascade({ CascadeType.REMOVE })
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Subscriber subscriber;

	private String number;

	private String band;
	private String security;
	private String scv;
	private String adsl;

	public Phone() {

	}

	public Phone(Long id, Subscriber subscriber, String number, String band, String security, String scv, String adsl) {
		this.id = id;
		this.subscriber = subscriber;
		this.number = number;
		this.band = band;
		this.security = security;
		this.scv = scv;
		this.adsl = adsl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long aId) {
		id = aId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String aNumber) {
		number = aNumber;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String aBand) {
		band = aBand;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String aSecurity) {
		security = aSecurity;
	}

	public String getScv() {
		return scv;
	}

	public void setScv(String aScv) {
		scv = aScv;
	}

	public String getAdsl() {
		return adsl;
	}

	public void setAdsl(String aAdsl) {
		adsl = aAdsl;
	}

	public Subscriber getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(Subscriber aSubscriber) {
		subscriber = aSubscriber;
	}

	@Override
	public String toString() {
		String phoneData = "";

		return phoneData.concat("id: ").concat(String.valueOf(id)).concat(" --- ФИО: ").concat(subscriber.getName()).concat(" --- Номер: ").concat(number).concat(" --- Громпол: ").concat(band)
				.concat(" --- Охрана: ").concat(security).concat(" --- СЦВ: ").concat(scv).concat(" --- ADSL: ").concat(adsl);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adsl == null) ? 0 : adsl.hashCode());
		result = prime * result + ((band == null) ? 0 : band.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((scv == null) ? 0 : scv.hashCode());
		result = prime * result + ((security == null) ? 0 : security.hashCode());
		result = prime * result + ((subscriber == null) ? 0 : subscriber.hashCode());
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
		Phone other = (Phone) obj;
		if (adsl == null) {
			if (other.adsl != null)
				return false;
		} else if (!adsl.equals(other.adsl))
			return false;
		if (band == null) {
			if (other.band != null)
				return false;
		} else if (!band.equals(other.band))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (scv == null) {
			if (other.scv != null)
				return false;
		} else if (!scv.equals(other.scv))
			return false;
		if (security == null) {
			if (other.security != null)
				return false;
		} else if (!security.equals(other.security))
			return false;
		if (subscriber == null) {
			if (other.subscriber != null)
				return false;
		} else if (!subscriber.equals(other.subscriber))
			return false;
		return true;
	}

}
