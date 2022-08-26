package com.noticeboard.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.noticeboard.common.EncryptUtils;
import com.noticeboard.user.bo.UserBO;
import com.noticeboard.user.model.User;

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
	/**
	 * 닉네임 중복체크
	 * @param nickName
	 * @return
	 */
	@RequestMapping("/chk_duplicated_nickName")
	public Map<String, Object> chkDuplicatedNickName(
			@RequestParam("nickName") String nickName	
			){
			Map<String, Object> result = new HashMap<>();
			boolean existLoginId = userBO.getUserByNickName(nickName);
		
				result.put("result", existLoginId);
				return result;
				
			
	}
	/**
	 * 회원가입
	 * @param loginId
	 * @param password
	 * @param name
	 * @param nickName
	 * @param eMail
	 * @param phoneNum
	 * @return
	 */
	@PostMapping("/sign_up")
	public Map <String, Object> signUp(
			@RequestParam("loginId") String loginId
			,@RequestParam("password") String password
			,@RequestParam("name") String name
			,@RequestParam("nickName") String nickName
			,@RequestParam("eMail") String eMail
			,@RequestParam("phoneNum") String phoneNum
			){
		
			Map<String, Object> result = new HashMap<>();
			String encryptPassword = EncryptUtils.md5(password);
			userBO.addUser(loginId, encryptPassword, name, nickName, eMail, phoneNum);
			
			result.put("result", "success");
			
			return result;
		
	}
	/**
	 * 로그인
	 * @param loginId
	 * @param loginPassword
	 * @param session
	 * @return
	 */
	@PostMapping("/sign_in")
	public Map<String, Object> signIn(
			@RequestParam("loginId") String loginId
			,@RequestParam("loginPassword") String loginPassword
			,HttpSession session
			){
		Map<String, Object> result = new HashMap<>();
		
		// 비밀번호 암호화
		String encryptPassword = EncryptUtils.md5(loginPassword);
		// db
		boolean login = userBO.getByLoginIdAndPassword(loginId, encryptPassword);
		
		// 결과
		if(login) {
			result.put("result", "success");
			// db
			User user = userBO.getByLoginIdAndPasswordforId(loginId, encryptPassword);
			// 세션 저장
			session.setAttribute("loginId", loginId);
			session.setAttribute("userId", user.getId());
			session.setAttribute("userNickname", user.getNick_name());
		}else{
			result.put("errorMessage", "아이디 혹은 비밀번호가 일치하지 않습니다.");
		}
		
		return result;
	}
	
	
}
