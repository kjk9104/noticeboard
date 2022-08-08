package com.noticeboard.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.noticeboard.user.bo.UserBO;

@RestController
@RequestMapping("/user")
public class userRestController {
	@Autowired
	private UserBO userBO;
	
	/**
	 * 아이디 중복 체크
	 * @param loginId
	 * @return
	 */
	@RequestMapping("/chk_duplicated_id")
	public Map<String, Object> chkDuplicatedId(
			@RequestParam("loginId") String loginId	
			){
			Map<String, Object> result = new HashMap<>();
			boolean existLoginId = userBO.getUserByLoginId(loginId);
		
				result.put("result", existLoginId);
				return result;
				
			
	}
	@RequestMapping("/chk_duplicated_nickName")
	public Map<String, Object> chkDuplicatedNickName(
			@RequestParam("nickName") String nickName	
			){
			Map<String, Object> result = new HashMap<>();
			boolean existLoginId = userBO.getUserByNickName(nickName);
		
				result.put("result", existLoginId);
				return result;
				
			
	}
}
