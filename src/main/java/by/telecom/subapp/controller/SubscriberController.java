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
//@RequestMapping("/")
public class SubscriberController {
	@Autowired
	private SubscriberService subscriberService;
	
	@Autowired
	private PhoneService phoneService;

	
		
}
