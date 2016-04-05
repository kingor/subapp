package by.telecom.subapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Phone implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_subscriber")
	private Subscriber subscriber;

	private String number;
	private String band;
	private String security;
	private String scv;
	private String adsl;

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

		return phoneData.concat("id: ").concat(String.valueOf(id)).concat(" --- ФИО: ").concat(subscriber.getName()).concat(" --- Номер: ")
				.concat(number).concat(" --- Громпол: ").concat(band).concat(" --- Охрана: ").concat(security).concat(" --- СЦВ: ").concat(scv)
				.concat(" --- ADSL: ").concat(adsl);
	}

}
