package by.telecom.subapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.telecom.subapp.model.Subscriber;
import by.telecom.subapp.service.SubscriberService;

@Controller
@RequestMapping("/")
public class SubscriberController {
	@Autowired
	private SubscriberService subscriberService;

	@RequestMapping(value = "/subscribers.do", method = RequestMethod.GET)
	public String getSubscribers(
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "sort", required = false) String sort, Model model) {
        if(!"name".equals(sort) && !"address".equals(sort) && !"comment".equals(sort))
            sort = "name";
        if(!"asc".equals(order) && !"desc".equals(order))
            order = "asc";
		List<Subscriber> subscribers = subscriberService.getAll(Subscriber.class, sort, order);

		model.addAttribute("subscribers", subscribers);

		return "viewSubscribers";
	}
	
	@RequestMapping(value = "/subscriberSearch.do", method = RequestMethod.GET)
	public String getSubscribers(
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "sort", required = false) String sort, 
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "comment", required = false) String comment,
			Model model) {
        if(!"name".equals(sort) && !"address".equals(sort) && !"comment".equals(sort))
            sort = "name";
        if(!"asc".equals(order) && !"desc".equals(order))
            order = "asc";
		List<Subscriber> subscribers = subscriberService.getByParameter(name, address, comment, sort, order);

		model.addAttribute("subscribers", subscribers);

		return "viewSubscriberSearch";
	}
	
	@RequestMapping(value = "/subscribersFull.do", method = RequestMethod.GET)
	public String getSubscribersFull(
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "sort", required = false) String sort, Model model) {
        if(!"name".equals(sort) && !"address".equals(sort) && !"comment".equals(sort))
            sort = "name";
        if(!"asc".equals(order) && !"desc".equals(order))
            order = "asc";
		List<Subscriber> subscribers = subscriberService.getAll(Subscriber.class, sort, order);

		model.addAttribute("subscribers", subscribers);

		return "viewSubscribers";
	}
	
}
