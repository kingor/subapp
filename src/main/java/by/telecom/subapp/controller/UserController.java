package by.telecom.subapp.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.telecom.subapp.model.Phone;
import by.telecom.subapp.model.Subscriber;
import by.telecom.subapp.service.PhoneService;
import by.telecom.subapp.service.SubscriberService;

@Controller
@Secured({ "ROLE_USER", "ROLE_OPERATOR", "ROLE_ADMIN" })
public class UserController {

	@Autowired
	SubscriberService subscriberService;

	@Autowired
	PhoneService phoneService;

	private static Logger logger = Logger.getLogger(UserController.class.getSimpleName());

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String getIndex(Model model) {
		logger.info("CONTROLLER - Received request to show Index page");
		Long countOfSubscribers = subscriberService.getCountRow();
		Long countOfPhones = phoneService.getCountRow();
		model.addAttribute("countOfSubscribers", countOfSubscribers);
		model.addAttribute("countOfPhones", countOfPhones);
		return "index";
	}

	/*
	 * All Subscribers
	 */
	@RequestMapping(value = "/subscribers.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String getSubscribers(@RequestParam(value = "order", required = false) String order, @RequestParam(value = "sort", required = false) String sort, Model model) {
		logger.info("CONTROLLER - caused /subscriber.do");

		List<Subscriber> subscribers = subscriberService.getAll(sort, order);
		model.addAttribute("subscribers", subscribers);

		return "viewSubscribers";
	}

	/*
	 * Search of Subscriber
	 */
	@RequestMapping(value = "/subscriberSearch.do", method = RequestMethod.GET)
	public String getSubscriberSearch(@RequestParam(value = "order", required = false) String order, @RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "name", required = false) String name, @RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "comment", required = false) String comment, Model model) {
		logger.info("CONTROLLER - caused /subscriberSearch.do");

		List<Subscriber> subscribers = subscriberService.getByParameter(name, address, comment, sort, order);
		model.addAttribute("subscriberSearch", subscribers);

		/*
		 * filled search fields
		 */
		model.addAttribute("name", name);
		model.addAttribute("address", address);
		model.addAttribute("comment", comment);

		return "viewSubscriberSearch";
	}

	/*
	 * Full info about Subscriber
	 */
	@RequestMapping(value = "/subscriberFull.do", method = RequestMethod.POST)
	public String getSubscribersFull(@RequestParam(value = "subscriberSelect", required = false) Long subscriberId, Model model) {
		logger.info("CONTROLLER - caused /subscriberFull.do");

		return "redirect:subscriberFull.do?id=" + subscriberId;
	}

	/*
	 * redirect to Full info about Subscriber
	 */
	@RequestMapping(value = "/subscriberFull.do", method = RequestMethod.GET)
	public String getSubscribersFullGet(@RequestParam(value = "id", required = false) Long subscriberId, Model model) {
		logger.info("CONTROLLER - caused /subscriberFull.do");
		Subscriber subscriber = subscriberService.read(subscriberId);

		List<Phone> listPhones = phoneService.getBySubscriber(subscriber);

		model.addAttribute("subscriber", subscriber);
		model.addAttribute("phones", listPhones);

		return "viewSubscriberFull";
	}

	@RequestMapping(value = "/phones", method = RequestMethod.GET)
	public String getPhones(@RequestParam(value = "order", required = false) String order, @RequestParam(value = "sort", required = false) String sort, Model model) {
		logger.info("CONTROLLER - caused /phones");
		List<Phone> phones = phoneService.getAll(sort, order);

		model.addAttribute("phones", phones);

		return "viewPhones";
	}

	@RequestMapping(value = "/phoneSearch.do", method = RequestMethod.GET)
	public String getPhoneSearch(@RequestParam(value = "order", required = false) String order, @RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "number", required = false) String number, @RequestParam(value = "band", required = false) String band,
			@RequestParam(value = "security", required = false) String security, @RequestParam(value = "scv", required = false) String scv,
			@RequestParam(value = "adsl", required = false) String adsl, @RequestParam(value = "name", required = false) String name, Model model) {
		logger.info("CONTROLLER - caused /phoneSearch.do");

		List<Phone> phones = phoneService.getByParameter(number, band, security, scv, adsl, name, sort, order);
		model.addAttribute("phoneSearch", phones);

		/*
		 * filled search fields
		 */
		model.addAttribute("number", number);
		model.addAttribute("band", band);
		model.addAttribute("security", security);
		model.addAttribute("scv", scv);
		model.addAttribute("adsl", adsl);
		model.addAttribute("name", name);
		return "viewPhoneSearch";
	}

}
