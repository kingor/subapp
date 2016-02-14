package by.telecom.subapp.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.telecom.subapp.model.Actor;
import by.telecom.subapp.model.Subscriber;
import by.telecom.subapp.service.PhoneService;
import by.telecom.subapp.service.SubscriberService;
import by.telecom.subapp.model.Phone;


@Controller
@RequestMapping("/")
public class SubscriberController {
	@Autowired
	private SubscriberService subscriberService;
	
	@Autowired
	private PhoneService phoneService;

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
	public String getSubscriberSearch(
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

		model.addAttribute("subscriberSearch", subscribers);

		return "viewSubscriberSearch";
	}
	
	@RequestMapping(value = "/subscriberFull.do", method = RequestMethod.POST)
	public String getSubscribersFull(
			@RequestParam(value = "subscriberSelect", required = false) Long subscriberId, Model model) {

		Subscriber subscriber = subscriberService.read(Subscriber.class, subscriberId);

        List<Phone> listPhones = phoneService.getBySubscriber(subscriber);

		model.addAttribute("subscriber", subscriber);
		model.addAttribute("phones", listPhones);

		return "viewSubscriberFull";
	}
	
	@RequestMapping(value = "/createSubscriber", method = RequestMethod.GET)
	public String createSubscriber(Model model) {
		model.addAttribute("subscriberAttr", new Subscriber());
		return "createSubscriber";
	}
	
	@RequestMapping(value = "/createSubscriber.do", method = RequestMethod.POST)
	public String createSubscriberPost(
			@ModelAttribute("subscriberAttr") Subscriber subscriber, Model model) {

		subscriberService.create(subscriber);
		System.out.println("!!!!!!!!!!!!!!!!+++++++++" + subscriber.getId() + "!!!!!!!!!!!!!");
		model.addAttribute("subscriber", subscriber);
		Phone phone = new Phone();
		phone.setSubscriber(subscriber);
		System.out.println("!!!!!!!!!!!!!!!!+++++++++" + phone.getSubscriber().getId() + "!!!!!!!!!!!!!");
		model.addAttribute("phoneAttr", phone);

		return "createPhone";
	}
	
	@RequestMapping(value = "/subscriberSearchEdit.do", method = RequestMethod.GET)
	public String getSubscriberEdit(
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

		model.addAttribute("subscriberSearchEdit", subscribers);

		return "viewSubscriberEdit";
	}
	
	@RequestMapping(value = "/editSubscriberView.do", method = RequestMethod.POST)
	public String editSubscriber(
			@RequestParam(value = "subscriberSelect", required = false) Long subscriberId, 
			Model model) {
		Subscriber subscriber = subscriberService.read(Subscriber.class, subscriberId);
		model.addAttribute("subscriber", subscriber);
		return "editSubscriber";
	}
	
	@RequestMapping(value = "/editSubscriber.do", method = RequestMethod.POST)
	public String editSubscriberDo(
			@ModelAttribute("subscriberAttr") Subscriber subscriber, Model model) {

		subscriberService.update(subscriber);
		return "index";
	}
	
}
