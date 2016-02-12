/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.telecom.subapp.model;

import by.telecom.subapp.model.Subscriber;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Family_P
 */
@Entity
public class Phone implements Serializable{
	
	@Id
	@GeneratedValue
    private Long id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "id_subscriber")
    private Subscriber subscriber;
	
    private String number;
    private String band;
    private String security;
    private String scv;
    private String adsl;
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long aId){
        id = aId;
    }
    
    public String getNumber(){
        return number;
    }
    
    public void setNumber(String aNumber){
        number= aNumber;
    }
    
    public String getBand(){
        return band;
    }
    
    public void setBand(String aBand){
        band = aBand;
    }
    
    public String getSecurity(){
        return security;
    }
    
    public void setSecurity(String aSecurity){
        security = aSecurity;
    }
    
    public String getScv(){
        return scv;
    }
    
    public void setScv(String aScv){
        scv = aScv;
    }
    
    public String getAdsl(){
        return adsl;
    }
    
    public void setAdsl(String aAdsl){
        adsl = aAdsl;
    }
    
    public Subscriber getSubscriber(){
        return subscriber;
    }
    
    public void setSubscriber(Subscriber aSubscriber) {
        subscriber = aSubscriber;
    }
}
