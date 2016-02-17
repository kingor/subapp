/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.telecom.subapp.controller;

import by.telecom.subapp.model.Actor;
import by.telecom.subapp.model.Phone;
import by.telecom.subapp.model.Subscriber;
import by.telecom.subapp.model.User;
import by.telecom.subapp.service.ActorService;
import by.telecom.subapp.service.PhoneService;
import by.telecom.subapp.service.SubscriberService;
import by.telecom.subapp.service.UserService;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author asup
 */
@Controller
@RequestMapping("/")
public class MainController {

	 protected static Logger logger = Logger.getLogger("controller");
	 
	@Resource(name = "actorService")
	private ActorService actorService;

	@RequestMapping(value = "/actors", method = RequestMethod.GET)
	public String getActors(Model model) {
		List<Actor> actors = actorService.getAll();

		model.addAttribute("actors", actors);

		return "actorspage";
	}
	
//	@Autowired
//	private UserService userService;
//
//	@RequestMapping(value = "/users", method = RequestMethod.GET)
//	public String getUsers(Model model) {
//		List<User> users = userService.getAll();
//
//		model.addAttribute("users", users);
//
//		return "userspage";
//	}

	
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String getIndex(Model model) {

		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(Model model) {

		return "login";
	}
	
	@RequestMapping(value = "/actors/add", method = RequestMethod.GET)
	public String getAdd(Model model) {
		logger.debug("Received request to show add page");

		// Create new Person and add to model
		// This is the formBackingOBject
		model.addAttribute("actorAttribute", new Actor());

		// This will resolve to /WEB-INF/jsp/addpage.jsp
		return "addpage";
	}

	/**
	 * Adds a new person by delegating the processing to PersonService. Displays
	 * a confirmation JSP page
	 *
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/actors/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("actorAttribute") Actor actor) {
		logger.debug("Received request to add new person");

		// The "personAttribute" model has been passed to the controller from
		// the JSP
		// We use the name "personAttribute" because the JSP uses that name

		// Call PersonService to do the actual adding
		actorService.add(actor);

		// This will resolve to /WEB-INF/jsp/addedpage.jsp
		return "addedpage";
	}

	/**
	 * Deletes an existing person by delegating the processing to PersonService.
	 * Displays a confirmation JSP page
	 *
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/actors/delete", method = RequestMethod.GET)
	public String delete(
			@RequestParam(value = "id", required = true) Integer id, Model model) {

		logger.debug("Received request to delete existing person");

		// Call PersonService to do the actual deleting
		actorService.delete(id);

		// Add id reference to Model
		model.addAttribute("id", id);

		// This will resolve to /WEB-INF/jsp/deletedpage.jsp
		return "deletedpage";
	}

	/**
	 * Retrieves the edit page
	 *
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/actors/edit", method = RequestMethod.GET)
	public String getEdit(
			@RequestParam(value = "id", required = true) Integer id, Model model) {
		logger.debug("Received request to show edit page");

		// Retrieve existing Person and add to model
		// This is the formBackingOBject
		model.addAttribute("actorAttribute", actorService.get(id));

		// This will resolve to /WEB-INF/jsp/editpage.jsp
		return "editpage";
	}

	/**
	 * Edits an existing person by delegating the processing to PersonService.
	 * Displays a confirmation JSP page
	 *
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/actors/edit", method = RequestMethod.POST)
	public String saveEdit(@ModelAttribute("personAttribute") Actor actor,
			@RequestParam(value = "id", required = true) Integer id, Model model) {
		logger.debug("Received request to update person");

		// The "personAttribute" model has been passed to the controller from
		// the JSP
		// We use the name "personAttribute" because the JSP uses that name

		// We manually assign the id because we disabled it in the JSP page
		// When a field is disabled it will not be included in the
		// ModelAttribute
		actor.setId(id);

		// Delegate to PersonService for editing
		actorService.update(actor);

		// Add id reference to Model
		model.addAttribute("id", id);

		// This will resolve to /WEB-INF/jsp/editedpage.jsp
		return "editedpage";
	}
}
