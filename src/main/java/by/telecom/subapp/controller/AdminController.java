package by.telecom.subapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.telecom.subapp.model.User;
import by.telecom.subapp.service.UserService;

@Controller
@Secured("ROLE_ADMIN")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/userSearchEdit.do", method = RequestMethod.GET)
	public String getUsers(
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "sort", required = false) String sort, Model model) {
        if(!"name".equals(sort) && !"login".equals(sort))
            sort = "name";
        if(!"asc".equals(order) && !"desc".equals(order))
            order = "asc";
		List<User> users = userService.getAll(User.class, sort, order);

		model.addAttribute("userSearchEdit", users);

		return "viewUserEdit";
	}
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String phoneSearchEdit(Model model) {	
		
		return "createUser";
	}

}
