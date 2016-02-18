/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.telecom.subapp.dao;

import java.util.List;

import org.apache.log4j.Logger;

import by.telecom.subapp.model.Subscriber;
import by.telecom.subapp.model.Phone;

/**
 *
 * @author ASUP8
 */
public interface PhoneDao extends GenericDao<Phone, Long>{

    List<Phone> getBySubscriber(Subscriber subscriber);
    
    List<Phone> getByParameter(String number, String band, 
            String security, String scv, String adsl, String name, String sort, String orderType);
}
