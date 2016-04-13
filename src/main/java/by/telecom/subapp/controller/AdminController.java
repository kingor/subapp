package by.telecom.subapp.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

	private static final String TYPE_INSERT = "Insert";
	private static final String TYPE_BEFORE_IUPDATE = "Before Update";
	private static final String TYPE_AFTER_UPDATE = "After Update";
	private static final String TYPE_DELETE = "Dalete";
	private static Logger logger = Logger.getLogger(AdminController.class);

	/**
	 * Getting the viewUserEdit.jsp
	 * 
	 * @return viewUserEdit is name of jsp
	 */
	@RequestMapping(value = "/userSearchEdit.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String getUserSearchEdit(@RequestParam(value = "order", required = false) String orderType,
			@RequestParam(value = "sort", required = false) String sort, @RequestParam(value = "login", required = false) String login,
			@RequestParam(value = "name", required = false) String name, @RequestParam(value = "category", required = false) Integer category,
			Model model, Principal principal, HttpServletRequest request) {
		logger.info("CONTROLLER - caused /userSearchEdit.do");
		List<User> users = userService.getByParameter(login, name, 1, sort, orderType);
		model.addAttribute("userSearchEdit", users);

		/*
		 * filled search fields
		 */
		model.addAttribute("login", login);
		model.addAttribute("name", name);
		model.addAttribute("category", category);
		return "viewUserEdit";
	}

	/**
	 * Getting the createUser.jsp
	 * 
	 * @return createUser is name of jsp
	 */
	@RequestMapping(value = "/createUser", method = RequestMethod.GET)
	public String createUser(Model model) {
		logger.info("CONTROLLER - caused /createUser");
		model.addAttribute("user", new User());

		return "createUser";
	}

	/**
	 * Create User
	 */
	@RequestMapping(value = "/createUser.do", method = RequestMethod.POST)
	public String createUserDo(@ModelAttribute("user") User user, Model model, Principal principal) {
		logger.info("CONTROLLER - caused /createUser.do");
		userService.create(user);

		logService.create(principal.getName(), TYPE_INSERT, user.toString());

		return "index";
	}

	/**
	 * View User edit page
	 */
	@RequestMapping(value = "/editUserView.do", method = RequestMethod.POST)
	public String getEditUserView(@RequestParam(value = "userSelect", required = false) Long userId, Model model, Principal principal) {
		logger.info("CONTROLLER - caused /editUserView.do");
		User user = userService.read(userId);
		model.addAttribute("userAttr", user);

		logService.create(principal.getName(), TYPE_BEFORE_IUPDATE, user.toString());

		return "editUser";
	}

	/**
	 * Edit of User
	 */
	@RequestMapping(value = "/editUser.do", method = RequestMethod.POST)
	public String editUser(@ModelAttribute("userAttr") User user, Model model, Principal principal) {
		logger.info("CONTROLLER - caused /editUser.do");
		userService.update(user);

		logService.create(principal.getName(), TYPE_AFTER_UPDATE, user.toString());

		return "index";
	}

	/**
	 * Delete User
	 * 
	 * @return viewUserEdit is name of JSP
	 */
	@RequestMapping(value = "/deleteUser.do", method = RequestMethod.POST)
	public String deleteUser(@RequestParam(value = "userSelect", required = false) Long userId, Model model, Principal principal) {
		logger.info("CONTROLLER - caused /deleteUser.do");
		User user = userService.read(userId);
		userService.delete(user);

		logService.create(principal.getName(), TYPE_DELETE, user.toString());

		return "viewUserEdit";
	}

	/**
	 * View Log page
	 */
	@RequestMapping(value = "/logSearch.do", method = RequestMethod.GET)
	public String getLogSearch(@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "sort", required = false) String sort, @RequestParam(value = "user", required = false) String user,
			@RequestParam(value = "dateStart", required = false) String dateStartParam,
			@RequestParam(value = "dateEnd", required = false) String dateEndParam, @RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "comment", required = false) String comment, Model model, HttpServletRequest request) {
		logger.info("CONTROLLER - caused /logSearch.do");

		sort = "date";
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
		List<Log> logList = logService.getByParameter(user, dateStart, dateEnd, type, comment);
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

	/**
	 * Retrieves the download file in PDF format.
	 * 
	 * @return the View and the Model combined
	 */
	@RequestMapping(value = "/download/pdf", method = RequestMethod.GET)
	public ModelAndView doSalesReportPDF(@RequestParam(value = "user", required = false) String user,
			@RequestParam(value = "dateStart", required = false) String dateStartParam,
			@RequestParam(value = "dateEnd", required = false) String dateEndParam, @RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "comment", required = false) String comment, ModelAndView modelAndView) {

		logger.info("Received request to download PDF report");

		// pdfReport is the View of our application
		// This is declared inside the /WEB-INF/jasper-views.xml
		modelAndView = new ModelAndView("pdfReport", getReportParam(user, dateStartParam, dateEndParam, type, comment));

		return modelAndView;
	}

	/**
	 * Retrieves the download file in XLS format
	 * 
	 * @return modelAndView
	 */
	@RequestMapping(value = "/download/xls", method = RequestMethod.GET)
	public ModelAndView doSalesReportXLS(@RequestParam(value = "user", required = false) String user,
			@RequestParam(value = "dateStart", required = false) String dateStartParam,
			@RequestParam(value = "dateEnd", required = false) String dateEndParam, @RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "comment", required = false) String comment, ModelAndView modelAndView) {
		logger.info("Received request to download XLS report");

		// pdfReport is the View of our application
		// This is declared inside the /WEB-INF/jasper-views.xml
		modelAndView = new ModelAndView("xlsReport", getReportParam(user, dateStartParam, dateEndParam, type, comment));

		// Return the View and the Model combined
		return modelAndView;
	}

	/**
	 * Retrieves the download file in html format
	 * 
	 * @return modelAndView
	 */
	@RequestMapping(value = "/download/html", method = RequestMethod.GET)
	public ModelAndView doSalesReportHtml(@RequestParam(value = "user", required = false) String user,
			@RequestParam(value = "dateStart", required = false) String dateStartParam,
			@RequestParam(value = "dateEnd", required = false) String dateEndParam, @RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "comment", required = false) String comment, ModelAndView modelAndView) {
		logger.info("Received request to download Html report");

		// pdfReport is the View of our application
		// This is declared inside the /WEB-INF/jasper-views.xml
		modelAndView = new ModelAndView("htmlReport", getReportParam(user, dateStartParam, dateEndParam, type, comment));

		// Return the View and the Model combined
		return modelAndView;
	}

	/**
	 * Getting report parameters
	 * 
	 * @return map with datasource, dateStart, dateEnd
	 */
	public Map<String, Object> getReportParam(String user, String dateStartParam, String dateEndParam, String type, String comment) {

		String sort = "date";
		String order = "asc";

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
		List<Log> logList = logService.getByParameter(user, dateStart, dateEnd, type, comment);

		// Assign the datasource to an instance of JRDataSource
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(logList);

		// We are required to pass our datasource as a map parameter
		// parameterMap is the Model of our application
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("datasource", beanColDataSource);
		parameterMap.put("dateStart", dateStart);
		parameterMap.put("dateEnd", dateEnd);

		return parameterMap;
	}
}
