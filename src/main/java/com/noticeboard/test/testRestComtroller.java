package com.noticeboard.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class testRestComtroller {

	@PostMapping("/create")
	public Map<String, Object> createTest(){
		Map<String, Object> result = new HashMap<>();
		
		return result;
	}
}
