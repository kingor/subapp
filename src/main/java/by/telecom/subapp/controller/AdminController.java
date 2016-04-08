package by.telecom.subapp.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import by.telecom.subapp.report.Report;
import by.telecom.subapp.service.LogService;
import by.telecom.subapp.service.UserService;

@Controller
@Secured("ROLE_ADMIN")
public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private LogService logService;

	@Autowired
	private Report report;

	private static Logger logger = Logger.getLogger(AdminController.class);

	/*
	 * View edit User
	 */
	@RequestMapping(value = "/userSearchEdit.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String getUserSearchEdit(@RequestParam(value = "order", required = false) String orderType,
			@RequestParam(value = "sort", required = false) String sort, @RequestParam(value = "login", required = false) String login,
			@RequestParam(value = "name", required = false) String name, @RequestParam(value = "category", required = false) Integer category,
			Model model, Principal principal, HttpServletRequest request) {
		logger.info("CONTROLLER - caused /userSearchEdit.do");
		if (!"name".equals(sort) && !"login".equals(sort))
			sort = "name";
		if (!"asc".equals(orderType) && !"desc".equals(orderType))
			orderType = "asc";
		List<User> users = userService.getByParameter(login, name, 1, sort, orderType);

		model.addAttribute("userSearchEdit", users);

		String pathForSaving = request.getServletContext().getRealPath("resources/reports/User_report.pdf");
		String pathForPattern = request.getServletContext().getRealPath("resources/report_template/user_template.jrxml");

		report.create(pathForSaving, pathForPattern, users);

		/*
		 * filled search fields
		 */
		model.addAttribute("login", login);
		model.addAttribute("name", name);
		model.addAttribute("category", category);
		return "viewUserEdit";
	}

	/*
	 * View Create User
	 */
	@RequestMapping(value = "/createUser", method = RequestMethod.GET)
	public String createUser(Model model) {
		logger.info("CONTROLLER - caused /createUser");
		model.addAttribute("user", new User());

		return "createUser";
	}

	/*
	 * Create User
	 */
	@RequestMapping(value = "/createUser.do", method = RequestMethod.POST)
	public String createUserDo(@ModelAttribute("user") User user, Model model, Principal principal) {
		logger.info("CONTROLLER - caused /createUser.do");
		userService.create(user);

		logService.create(principal.getName(), "Insert", user.toString());

		return "index";
	}

	/*
	 * View User edit page
	 */
	@RequestMapping(value = "/editUserView.do", method = RequestMethod.POST)
	public String getEditUserView(@RequestParam(value = "userSelect", required = false) Long userId, Model model, Principal principal) {
		logger.info("CONTROLLER - caused /editUserView.do");
		User user = userService.read(userId);
		model.addAttribute("userAttr", user);

		logService.create(principal.getName(), "Before Update", user.toString());

		return "editUser";
	}

	/*
	 * Edit of User
	 */
	@RequestMapping(value = "/editUser.do", method = RequestMethod.POST)
	public String editUser(@ModelAttribute("userAttr") User user, Model model, Principal principal) {
		logger.info("CONTROLLER - caused /editUser.do");
		userService.update(user);

		logService.create(principal.getName(), "After Update", user.toString());

		return "index";
	}

	/*
	 * Delete User
	 */
	@RequestMapping(value = "/deleteUser.do", method = RequestMethod.POST)
	public String deleteUser(@RequestParam(value = "userSelect", required = false) Long userId, Model model, Principal principal) {
		logger.info("CONTROLLER - caused /deleteUser.do");
		User user = userService.read(userId);
		userService.delete(user);

		logService.create(principal.getName(), "Delete", user.toString());

		return "viewUserEdit";
	}

	/*
	 * View Log page
	 */
	@RequestMapping(value = "/logSearch.do", method = RequestMethod.GET)
	public String getLogSearch(@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "sort", required = false) String sort, @RequestParam(value = "user", required = false) String user,
			@RequestParam(value = "dateStart", required = false) String dateStartParam,
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
		List<Log> logList = logService.getByParameter(user, dateStart, dateEnd, type, comment, sort, order);
		model.addAttribute("logSearch", logList);

		/*
		 * filled search fields
		 */
		model.addAttribute("dateStart", dateStart);
		model.addAttribute("dateEnd", dateEnd);
		model.addAttribute("user", user);
		model.addAttribute("type", type);
		model.addAttribute("comment", comment);

		return "viewLogSearch";
	}
}
