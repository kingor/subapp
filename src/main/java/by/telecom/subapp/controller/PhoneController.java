package by.telecom.subapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/")
public class PhoneController {
	@Autowired
	private PhoneService phoneService;
	
	@Autowired
	private SubscriberService subscriberService;

	@RequestMapping(value = "/phones", method = RequestMethod.GET)
	public String getPhones(
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "sort", required = false) String sort, Model model) {
			
		if(!"number".equals(sort) && !"band".equals(sort) && !"security".equals(sort))
			sort = "number";
		if(!"asc".equals(order) && !"desc".equals(order))
		    order = "asc";
		List<Phone> phones = phoneService.getAll(Phone.class, sort, order);

		model.addAttribute("phones", phones);

		return "viewPhones";
	}
	
	@RequestMapping(value = "/phoneSearch.do", method = RequestMethod.GET)
	public String getPhoneSearch(
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "sort", required = false) String sort, 
			@RequestParam(value = "number", required = false) String number,
			@RequestParam(value = "band", required = false) String band,
			@RequestParam(value = "security", required = false) String security,
			@RequestParam(value = "scv", required = false) String scv,
			@RequestParam(value = "adsl", required = false) String adsl,
			@RequestParam(value = "name", required = false) String name,
			Model model) {
        if(!"name".equals(sort) && !"address".equals(sort) && !"comment".equals(sort))
            sort = "name";
        if(!"asc".equals(order) && !"desc".equals(order))
            order = "asc";     
        
		List<Phone> phones = phoneService.getByParameter(number, band, security, scv, 
				adsl, name, sort, order);

		model.addAttribute("phoneSearch", phones);

		return "viewPhoneSearch";
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
}
