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
public class SubscriberDaoImpl implements SubscriberDao{
    
	@Autowired
	private SessionFactory sessionFactory;
	
    public List<Subscriber> getAll() {
    	List<Subscriber> list = (List<Subscriber>) sessionFactory.getCurrentSession().createQuery("from Subscriber").list();
		return list;
    }

   
/*
    public List<User> getByParameter(String login, String name, Integer category, String sort, String orderType) {
        Session session = null;
        List<User> all = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Order order = Order.asc(sort);
            if(orderType.equals("desc"))
                order = Order.desc(sort);
            all = session.createCriteria(User.class)
                    .add(Restrictions.like("login", "%"+login+"%"))
                    .add(Restrictions.like("name", "%"+name+"%"))
                    .add(Restrictions.ge("category", category))
                    .addOrder(order).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return null;//all; 
    }*/

    
}
