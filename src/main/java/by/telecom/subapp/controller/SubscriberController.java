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
@RequestMapping("/main")
public class SubscriberController {
	@Autowired
	private SubscriberService subscriberService;

	@RequestMapping(value = "/subscribers.do?sort=name&order=asc", method = RequestMethod.GET)
	public String getSubscribers(
			@RequestParam(value = "order", required = true) String order,
			@RequestParam(value = "sort", required = true) String sort, Model model) {
       /* if(!"name".equals(sort) && !"address".equals(sort) && !"comment".equals(sort))
            sort = "name";
        if(!"asc".equals(order) && !"desc".equals(order))
            order = "asc";*/
		List<Subscriber> subscribers = subscriberService.getAll(Subscriber.class, sort, order);

		model.addAttribute("subscribers", subscribers);

		return "viewSubscribers";
	}
	
}
