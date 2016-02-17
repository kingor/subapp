/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.telecom.subapp.dao;

import java.util.List;

import by.telecom.subapp.model.Subscriber;


/**
 *
 * @author ASUP8
 */
public interface SubscriberDao extends GenericDao<Subscriber, Long> {

	List<Subscriber> getByParameter(String name, String address, 
		   String comment, String sort, String orderType);
}
