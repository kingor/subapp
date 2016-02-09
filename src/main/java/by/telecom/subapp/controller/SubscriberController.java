package by.telecom.subapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.telecom.subapp.model.Subscriber;
import by.telecom.subapp.service.SubscriberService;

@Controller
@RequestMapping("/subscriber")
public class SubscriberController {
	@Autowired
	private SubscriberService subscriberService;

	@RequestMapping(value = "/subscribers.do", method = RequestMethod.GET)
	public String getSubscribers(Model model) {
		String sort = "";
        String order = "";
        //sort = request.getParameter("sort");
        //order = request.getParameter("order");
        if(!"name".equals(sort) && !"address".equals(sort) && !"comment".equals(sort))
            sort = "name";
        if(!"asc".equals(order) && !"desc".equals(order))
            order = "asc";
		List<Subscriber> subscribers = subscriberService.getAll(Subscriber.class, sort, order);

		model.addAttribute("subscribers", subscribers);

		return "viewSubscribers";
	}
	
}
