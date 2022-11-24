package com.noticeboard.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noticeboard.user.bo.UserBO;
import com.noticeboard.user.model.User;

@Controller
@RequestMapping("/user")
public class userController {

	@Autowired
	private UserBO userBO;
	
	// http://localhost/user/sign_in_view
	@RequestMapping("/sign_in_view")
	public String signInView(Model model) {
			
		model.addAttribute("viewName","user/sign_in");
		model.addAttribute("folder","user");
		return "/template/layout";
	}
	
	// http://localhost/user/sign_up_view
	@RequestMapping("/sign_up_view")
	public String signUpView(Model model) {
		
		model.addAttribute("viewName","user/sign_up");
		model.addAttribute("folder","user");
		return "/template/layout";
	}
	
	@RequestMapping("/sign_out")
	public String signOut(
			HttpSession session) {
		session.removeAttribute("loginId");
		session.removeAttribute("userId");
		session.removeAttribute("userNickname");
		
		return "redirect:/user/sign_in_view";
	}
	
	// http://localhost/user/detail_view
	@RequestMapping("/detail_view")
	public String detail(Model model
			,HttpSession session) {
		
		int userid = (int) session.getAttribute("userId");
		
		User user = userBO.getByUserId(userid);
		
		model.addAttribute("viewName","user/user_detail");
		model.addAttribute("user", user);
		
		return "/template/layout";
	}
}
