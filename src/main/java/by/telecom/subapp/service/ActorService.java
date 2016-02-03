/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.telecom.subapp.service;

import by.telecom.subapp.domain.Actor;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author asup
 */
@Service("actorService")
@Transactional
public class ActorService {

	 protected static Logger logger = Logger.getLogger("service");

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public List<Actor> getAll() {
		 logger.debug("get all Actors");
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Actor");

		return (List<Actor>) query.list();
	}

	public Actor get(Integer id) {
		logger.debug("get Actor");
		Session session = sessionFactory.getCurrentSession();
		Actor actor = (Actor) session.get(Actor.class, id);
		
		return actor;
	}
	
	public void add(Actor actor) {
		logger.debug("add Actor");
		Session session = sessionFactory.getCurrentSession();
		session.save(actor);
	}
	
	public void delete(Integer id) {
		logger.debug("delete Actor");
		Session session = sessionFactory.getCurrentSession();
		Actor actor = (Actor) session.get(Actor.class, id);
		session.delete(actor);
	}
	
	public void update (Actor actor) {
		logger.debug("update Actor");
		Session session = sessionFactory.getCurrentSession();
		Actor updatedActor = (Actor) session.get(Actor.class, actor.getId());
		updatedActor.setFirstName(actor.getFirstName());
		updatedActor.setLastName(actor.getLastName());
		session.update(updatedActor);
	}
}
