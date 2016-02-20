package by.telecom.subapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.telecom.subapp.model.Phone;
import by.telecom.subapp.model.Subscriber;
import by.telecom.subapp.service.PhoneService;
import by.telecom.subapp.service.SubscriberService;

@Controller
@Secured({"ROLE_OPERATOR", "ROLE_ADMIN"})
public class OperatorController {
	
	@Autowired
	SubscriberService subscriberService;
	
	@Autowired
	PhoneService phoneService;
	/*
	 * View create Subscriber
	 */
	@RequestMapping(value = "/createSubscriber", method = RequestMethod.GET)
	public String createSubscriber(Model model) {
		model.addAttribute("subscriberAttr", new Subscriber());
		return "createSubscriber";
	}
	
	/*
	 * Create of Subscriber
	 */
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
	
	/*
	 * View edit Subscriber
	 */
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
	
	/*
	 * View Subscriber edit page
	 */
	@RequestMapping(value = "/editSubscriberView.do", method = RequestMethod.POST)
	public String editSubscriber(
			@RequestParam(value = "subscriberSelect", required = false) Long subscriberId, 
			Model model) {
		Subscriber subscriber = subscriberService.read(Subscriber.class, subscriberId);
		model.addAttribute("subscriberAttr", subscriber);
		return "editSubscriber";
	}
	
	/*
	 * Edit of Subscriber
	 */
	@RequestMapping(value = "/editSubscriber.do", method = RequestMethod.POST)
	public String editSubscriberDo(
			@ModelAttribute("subscriberAttr") Subscriber subscriber, Model model) {

		subscriberService.update(subscriber);
		return "index";
	}
	
	/*
	 * Delete Subscriber
	 */
	@RequestMapping(value = "/deleteSubscriber.do", method = RequestMethod.POST)
	public String deleteSubscriber(
			@RequestParam(value = "subscriberSelect", required = false) Long subscriberId, 
			Model model) {
		Subscriber subscriber = subscriberService.read(Subscriber.class, subscriberId);
		subscriberService.delete(subscriber);
		return "viewSubscriberEdit";
	}
	
	/*
	 * View Create Phone
	 */	
	@RequestMapping(value = "/createPhoneNew", method = RequestMethod.GET)
	public String getCreatePhone(
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

		return "createPhoneNew";
	}
	
	/*
	 * View Create Phone
	 */	
	@RequestMapping(value = "/createPhoneNew.do", method = RequestMethod.POST)
	public String getCreatePhone1(
			@RequestParam("id_subscriber") Long subscriberId, Model model) {
		Subscriber subscriber = subscriberService.read(Subscriber.class, subscriberId);
		model.addAttribute("subscriber", subscriber);
		Phone phone = new Phone();
		phone.setSubscriber(subscriber);
		System.out.println("!!!!!!!!!!!!!!!!+++++++++" + phone.getSubscriber().getId() + "!!!!!!!!!!!!!");
		model.addAttribute("phoneAttr", phone);

		return "createPhone";
	}
	

	@RequestMapping(value = "/createPhone", method = RequestMethod.POST)
	public String createPhone(
			@ModelAttribute("phoneAttr") Phone phone,
			@RequestParam(value = "id_subscriber", required = false) Long subscriberId,Model model) {	
		
		phone.setSubscriber(subscriberService.read(Subscriber.class, subscriberId));
		System.out.println("!!!!!!!!!!!!!!!!+++++++++" + phone.getSubscriber().getId() + "!!!!!!!!!!!!!");
		phoneService.create(phone);
		model.addAttribute("subscriber", phone.getSubscriber());
		model.addAttribute("phone", phone);
		return "createFull";
	}
	
	@RequestMapping(value = "/phoneSearchEdit.do", method = RequestMethod.POST)
	public String phoneSearchEdit(Model model) {	
		
		return "viewPhoneEdit";
	}

}
