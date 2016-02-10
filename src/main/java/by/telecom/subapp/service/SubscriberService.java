package by.telecom.subapp.service;

import java.util.List;

import by.telecom.subapp.model.Subscriber;
import by.telecom.subapp.model.User;

public interface SubscriberService {
	
	public List getAll(Class<Subscriber> clazz, String sort, String orderType);
	
    Long create(Subscriber subscriber);
    
    Subscriber read(Class<Subscriber> classT, Long id);

    void update(Subscriber subscriber);

    void delete(Subscriber subscriber);

	public List<Subscriber> getByParameter(String name, String address, 
			   String comment, String sort, String orderType);
}
