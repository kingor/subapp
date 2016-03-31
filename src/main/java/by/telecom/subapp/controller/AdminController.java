package by.telecom.subapp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import by.telecom.subapp.model.Log;
import by.telecom.subapp.model.User;
import by.telecom.subapp.service.LogService;
import by.telecom.subapp.service.UserService;

@Controller
@Secured("ROLE_ADMIN")
public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private LogService logService;
	private static Logger logger = Logger.getLogger(AdminController.class.getSimpleName());

	@RequestMapping(value = "/userSearchEdit.do", method = RequestMethod.GET)
	public String getUsers(@RequestParam(value = "order", required = false) String order, @RequestParam(value = "sort", required = false) String sort, Model model) {
		logger.info("CONTROLLER - caused /userSearchEdit.do");
		if (!"name".equals(sort) && !"login".equals(sort))
			sort = "name";
		if (!"asc".equals(order) && !"desc".equals(order))
			order = "asc";
		List<User> users = userService.getAll(sort, order);

		model.addAttribute("userSearchEdit", users);

		return "viewUserEdit";
	}

	/*
	 * View Create User
	 */
	@RequestMapping(value = "/createUser", method = RequestMethod.GET)
	public String phoneSearchEdit(Model model) {
		logger.info("CONTROLLER - caused /createUser");
		model.addAttribute("user", new User());

		return "createUser";
	}

	/*
	 * Create User
	 */
	@RequestMapping(value = "/createUser.do", method = RequestMethod.POST)
	public String createSubscriberPost(@ModelAttribute("user") User user, Model model) {
		logger.info("CONTROLLER - caused /createUser.do");
		userService.create(user);

		return "index";
	}

	/*
	 * Delete User
	 */
	@RequestMapping(value = "/deleteUser.do", method = RequestMethod.POST)
	public String deleteUser(@RequestParam(value = "userSelect", required = false) Long userId, Model model) {
		logger.info("CONTROLLER - caused /deleteUser.do");
		User user = userService.read(userId);
		userService.delete(user);
		return "viewUserEdit";
	}

	/*
	 * View Log page
	 */
	@RequestMapping(value = "/logSearch.do", method = RequestMethod.GET)
	public String getLogSearch(@RequestParam(value = "order", required = false) String order, @RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "name", required = false) String name, @RequestParam(value = "dateStart", required = false) String dateStartParam,
			@RequestParam(value = "dateEnd", required = false) String dateEndParam, @RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "comment", required = false) String comment, Model model) {
		logger.info("CONTROLLER - caused /logSearch.do");
		if (!"date".equals(sort) && !"type".equals(sort) && !"comment".equals(sort))
			sort = "name";
		if (!"asc".equals(order) && !"desc".equals(order))
			order = "asc";

		Date dateStart;
		Date dateEnd;

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dateStart = formatter.parse(dateStartParam);
		} catch (Exception ex) {
			dateStart = new Date();
		}

		try {
			dateEnd = formatter.parse(dateEndParam);
		} catch (Exception ex) {
			dateEnd = new Date();
		}
		List<Log> logList = logService.getByParameter(name, dateStart, dateEnd, type, comment, sort, order);
		model.addAttribute("logSearch", logList);

		return "viewLogSearch";
	}
}
