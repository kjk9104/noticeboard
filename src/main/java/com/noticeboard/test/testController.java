package com.noticeboard.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class testController {

	// http://localhost/test/test_body
	@RequestMapping("/test_body")
	public String testBody() {
		return "/test";
	}
}
