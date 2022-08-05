package com.noticeboard.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class userController {

	// http://localhost/user/sign_in_view
	@RequestMapping("/sign_in_view")
	public String signInView(Model model) {
			
		model.addAttribute("viewName","sign_in");
		model.addAttribute("folder","user");
		return "/template/layout";
	}
	
	// http://localhost/user/sign_up_view
	@RequestMapping("/sign_up_view")
	public String signUpView(Model model) {
		
		model.addAttribute("viewName","sign_up");
		model.addAttribute("folder","user");
		return "/template/layout";
	}
	
}
