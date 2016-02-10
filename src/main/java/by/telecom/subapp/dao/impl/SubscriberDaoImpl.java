/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.telecom.subapp.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import by.telecom.subapp.dao.GenericDao;
import by.telecom.subapp.dao.SubscriberDao;
import by.telecom.subapp.model.Subscriber;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUP8
 */
@Repository
public class SubscriberDaoImpl extends GenericDaoImpl<Subscriber, Long> implements SubscriberDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Subscriber> getByParameter(String name, String address,
			String comment, String sort, String orderType) {
		Session session = null;
        List<Subscriber> all = null;
        
        session = sessionFactory.getCurrentSession();
    	Order order = Order.asc(sort);
        if(orderType.equals("desc"))
            order = Order.desc(sort);
        System.out.println("!!!!!!!!DEBAG name" + name + " address" + address + " comment" + comment );
        all = session.createCriteria(Subscriber.class)
                .add( Restrictions.like("name", "%"+name+"%"))
                .add( Restrictions.like("address", "%"+address+"%"))
                .add( Restrictions.like("comment", "%"+comment+"%"))
                .addOrder(order).list();
		return all;
	}
  
}
