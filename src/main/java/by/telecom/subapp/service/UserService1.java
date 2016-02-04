package by.telecom.subapp.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import by.telecom.subapp.model.User;

@Service("userService")
@Transactional
public class UserService1 {
	
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	public List<User> getAll() {
	//	 logger.debug("get all Actors");
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM User");

		return (List<User>) query.list();
	}

	public User get(Integer id) {
	//	logger.debug("get User");
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		
		return user;
	}

}
