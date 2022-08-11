package com.noticeboard.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.noticeboard.common.FileManagerSevice;
import com.noticeboard.inceptor.PermissionInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Autowired
	private PermissionInterceptor interceptor;
	
	// 웹의 이미지주소와 실제 파일 경로를 매핑해주는 설정
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
		.addResourceHandler("/images/**") // 이미지의 웹주소 http://localhost/images/kjk9104_16874828147854/sum.png
		.addResourceLocations("file:///" + FileManagerSevice.FILE_UPLODE_PATH); // 실제 파일이 있는 곳
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor)
		.addPathPatterns("/**")	 //  /** 아래 패스까지 모두 확인
		.excludePathPatterns("error", "/static/**", "/user/sign_out"); // 예외 - 인터셉터 안타게 
	}
}
