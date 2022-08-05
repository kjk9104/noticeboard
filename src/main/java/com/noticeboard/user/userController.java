package com.noticeboard.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class userController {

	@RequestMapping("/sign_up_view")
	public String signUpView() {
		
		
		return "/user/sign_up";
	}
	
}
