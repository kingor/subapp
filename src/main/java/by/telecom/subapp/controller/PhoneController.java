package by.telecom.subapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.telecom.subapp.model.Phone;
import by.telecom.subapp.model.Subscriber;
import by.telecom.subapp.service.PhoneService;

@Controller
@RequestMapping("/")
public class PhoneController {
	@Autowired
	private PhoneService phoneService;

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
}
