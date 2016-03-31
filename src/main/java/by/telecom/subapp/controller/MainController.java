/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.telecom.subapp.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author asup
 */
@Controller
public class MainController {

	protected static Logger logger = Logger.getLogger(MainController.class);

	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String getLogin(Model model) {
		if (logger.isDebugEnabled()) {
			logger.debug("Received request to show Login page");
		}
		return "login";
	}

}
