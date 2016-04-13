package by.telecom.subapp.controller;

import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
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
import by.telecom.subapp.service.LogService;
import by.telecom.subapp.service.PhoneService;
import by.telecom.subapp.service.SubscriberService;

@Controller
@Secured({ "ROLE_OPERATOR", "ROLE_ADMIN" })
public class OperatorController {

	@Autowired
	SubscriberService subscriberService;

	@Autowired
	PhoneService phoneService;

	@Autowired
	LogService logService;

	private static Logger logger = Logger.getLogger(UserController.class.getSimpleName());

	/*
	 * View create Subscriber
	 */
	@RequestMapping(value = "/createSubscriber", method = RequestMethod.GET)
	public String createSubscriber(Model model) {
		logger.info("CONTROLLER - caused /createSubscriber");
		model.addAttribute("subscriberAttr", new Subscriber());
		return "createSubscriber";
	}

	/*
	 * Create Subscriber
	 */
	@RequestMapping(value = "/createSubscriber.do", method = RequestMethod.POST)
	public String createSubscriberPost(@ModelAttribute("subscriberAttr") Subscriber subscriber, Model model, Principal principal) {
		logger.info("CONTROLLER - caused /createSubscriber.do");
		subscriberService.create(subscriber);
		logService.create(principal.getName(), "Insert", subscriber.toString());
		model.addAttribute("subscriber", subscriber);
		Phone phone = new Phone();
		phone.setSubscriber(subscriber);
		model.addAttribute("phoneAttr", phone);

		return "createPhone";
	}

	/*
	 * View edit Subscriber
	 */
	@RequestMapping(value = "/subscriberSearchEdit.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String getSubscriberEdit(@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "sort", required = false) String sort, @RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "address", required = false) String address, @RequestParam(value = "comment", required = false) String comment,
			Model model) {
		logger.info("CONTROLLER - caused /subscriberSearchEdit.do");

		List<Subscriber> subscribers = subscriberService.getByParameter(name, address, comment, sort, order);
		model.addAttribute("subscriberSearchEdit", subscribers);

		/*
		 * filled search fields
		 */
		model.addAttribute("name", name);
		model.addAttribute("address", address);
		model.addAttribute("comment", comment);
		return "viewSubscriberEdit";
	}

	/*
	 * View editSubscriber page
	 */
	@RequestMapping(value = "/editSubscriberView.do", method = RequestMethod.POST)
	public String editSubscriberView(@RequestParam(value = "subscriberSelect", required = false) Long subscriberId, Model model, Principal principal) {
		logger.info("CONTROLLER - caused /editSubscriberView.do");
		Subscriber subscriber = subscriberService.read(subscriberId);

		model.addAttribute("subscriberAttr", subscriber);

		logService.create(principal.getName(), "Before Update", subscriber.toString());

		return "editSubscriber";
	}

	/*
	 * Edit Subscriber
	 */
	@RequestMapping(value = "/editSubscriber.do", method = RequestMethod.POST)
	public String editSubscriberDo(@ModelAttribute("subscriberAttr") Subscriber subscriber, Model model, Principal principal) {
		logger.info("CONTROLLER - caused /editSubscriber.do");
		subscriberService.update(subscriber);

		logService.create(principal.getName(), "After Update", subscriber.toString());

		/*
		 * filled search fields
		 */
		model.addAttribute("name", subscriber.getName());
		model.addAttribute("address", subscriber.getAddress());
		model.addAttribute("comment", subscriber.getComment());
		return "viewSubscriberEdit";
	}

	/*
	 * Delete Subscriber
	 */
	@RequestMapping(value = "/deleteSubscriber.do", method = RequestMethod.POST)
	public String deleteSubscriber(@RequestParam(value = "subscriberSelect", required = false) Long subscriberId, Model model, Principal principal) {
		logger.info("CONTROLLER - caused /deleteSubscriber.do");
		Subscriber subscriber = subscriberService.read(subscriberId);
		subscriberService.delete(subscriber);

		logService.create(principal.getName(), "Delete", subscriber.toString());

		return "viewSubscriberEdit";
	}

	/*
	 * View Create Phone
	 */
	@RequestMapping(value = "/createPhoneNew", method = RequestMethod.GET)
	public String getCreatePhone(@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "sort", required = false) String sort, @RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "address", required = false) String address, @RequestParam(value = "comment", required = false) String comment,
			Model model) {
		logger.info("CONTROLLER - caused /createPhoneNew");

		List<Subscriber> subscribers = subscriberService.getByParameter(name, address, comment, sort, order);
		model.addAttribute("subscriberSearch", subscribers);

		/*
		 * filled search fields
		 */
		model.addAttribute("name", name);
		model.addAttribute("address", address);
		model.addAttribute("comment", comment);

		return "createPhoneNew";
	}

	/*
	 * View CreatePhoneNew
	 */
	@RequestMapping(value = "/createPhoneNew.do", method = RequestMethod.POST)
	public String getСreatePhoneNew(@RequestParam("id_subscriber") Long subscriberId, Model model) {
		logger.info("CONTROLLER - caused /createPhoneNew.do");
		Subscriber subscriber = subscriberService.read(subscriberId);
		model.addAttribute("subscriber", subscriber);
		Phone phone = new Phone();
		phone.setSubscriber(subscriber);
		model.addAttribute("phoneAttr", phone);

		return "createPhone";
	}

	/*
	 * Create Phone
	 */
	@RequestMapping(value = "/createPhone", method = RequestMethod.POST)
	public String createPhone(@ModelAttribute("phoneAttr") Phone phone, @RequestParam(value = "id_subscriber", required = false) Long subscriberId,
			Model model, Principal principal) {
		logger.info("CONTROLLER - caused /createPhone");
		phone.setSubscriber(subscriberService.read(subscriberId));
		phoneService.create(phone);
		model.addAttribute("subscriber", phone.getSubscriber());
		model.addAttribute("phone", phone);

		logService.create(principal.getName(), "Insert", phone.toString());

		return "createFull";
	}

	@RequestMapping(value = "/phoneSearchEdit.do", method = RequestMethod.GET)
	public String phoneSearchEdit(@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "sort", required = false) String sort, @RequestParam(value = "number", required = false) String number,
			@RequestParam(value = "band", required = false) String band, @RequestParam(value = "security", required = false) String security,
			@RequestParam(value = "scv", required = false) String scv, @RequestParam(value = "adsl", required = false) String adsl,
			@RequestParam(value = "name", required = false) String name, Model model) {
		logger.info("CONTROLLER - caused /phoneSearchEdit.do");
		List<Phone> phones = phoneService.getByParameter(number, band, security, scv, adsl, name, sort, order);

		model.addAttribute("phoneSearchEdit", phones);
		/*
		 * filled search fields
		 */
		model.addAttribute("number", number);
		model.addAttribute("band", band);
		model.addAttribute("security", security);
		model.addAttribute("scv", scv);
		model.addAttribute("adsl", adsl);
		model.addAttribute("name", name);
		return "viewPhoneEdit";
	}

	/*
	 * View Subscriber edit page
	 */
	@RequestMapping(value = "/editPhoneView.do", method = RequestMethod.POST)
	public String editPhone(@RequestParam(value = "phoneSelect", required = false) Long phoneId, Model model, Principal principal) {
		logger.info("CONTROLLER - caused /editPhoneView.do");
		Phone phone = phoneService.read(phoneId);
		model.addAttribute("phone", phone);
		model.addAttribute("subscriber", phone.getSubscriber());

		logService.create(principal.getName(), "Before Update", phone.toString());

		return "editPhone";
	}

	/*
	 * Edit Phone
	 */
	@RequestMapping(value = "/editPhone.do", method = RequestMethod.POST)
	public String editPhoneDo(@ModelAttribute("phone") Phone phone, @RequestParam(value = "id_subscriber", required = false) Long subscriberId,
			Model model, Principal principal) {
		logger.info("CONTROLLER - caused /editPhone.do");
		phone.setSubscriber(subscriberService.read(subscriberId));
		phoneService.update(phone);

		logService.create(principal.getName(), "After Update", phone.toString());

		/*
		 * filled search fields
		 */
		model.addAttribute("number", phone.getNumber());
		model.addAttribute("band", phone.getBand());
		model.addAttribute("security", phone.getSecurity());
		model.addAttribute("scv", phone.getScv());
		model.addAttribute("adsl", phone.getAdsl());
		model.addAttribute("name", phone.getSubscriber().getName());
		return "viewPhoneEdit";
	}

	/*
	 * Delete Phone
	 */
	@RequestMapping(value = "/deletePhone.do", method = RequestMethod.POST)
	public String deletePhone(@RequestParam(value = "phoneSelect", required = false) Long phoneId, Model model, Principal principal) {
		logger.info("CONTROLLER - caused /deletePhone.do");
		Phone phone = phoneService.read(phoneId);
		phoneService.delete(phone);

		logService.create(principal.getName(), "Delete", phone.toString());

		return "viewPhoneEdit";
	}

}
