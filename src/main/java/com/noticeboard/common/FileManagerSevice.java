package com.noticeboard.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManagerSevice {
//public final static String FILE_UPLODE_PATH ="D:\\kyu\\Spring_project\\memo\\workspace\\images/";
public final static String FILE_UPLODE_PATH ="C:\\Users\\kyu01\\Desktop\\kyu_spring_project\\workspace\\image/";

	
	
	// input : MultipartFile, userLoginId
	// output : String path
	public String savsFile(String userLoginId, MultipartFile file) {
		String[] arrChosungEng = {"k","K","n","d","D","r","m","b","B","s","S","a","j","J","ch","c","t","p","h"};
		String[] arrJungsungEng = {"a","e","ya","ae","eo","e","yeo","e","o","wa","wae","oe","yo","u","wo","we","wi","yu","eu","ui","i"};
		String[] arrJongsungEng = {"","k","K","ks","n","nj","nh","d","l","lg","lm","lb","ls","lt","lt","lp","lh","m","b","bs","s","ss","ng","j","ch","c","t","p","h"};
		String[] arrsingleJaumEng = {"r","R","rt","s","sw","sg","e","E","f","fr","fa","fq","ft","fx","fv","fg","a","q","Q","qt","t","T","d","w","W","c","z","x","v","g"};
		
		String word = userLoginId; // 분리할 단어
		String resultEng = ""; // 알파벳으로
		
		for(int i=0; i<word.length(); i++) {
			
			char chars =(char)(word.charAt(i) - 0xAC00);
			
			if(chars >= 0 &&chars <= 11172) {
				// A. 자음과 모음이 합쳐진 글자인경우
				
				// A-1 초/중/종성 분리
				int chosung = chars / (21* 28);
				int jungsung = chars % (21* 28)/28;
				int jongsung = chars % (21* 28)%28;
				
				// 알파벳으로
				resultEng = resultEng + arrChosungEng[chosung] + arrJungsungEng[jungsung];
				
					if(jongsung != 0x0000) {
						
						// A-3 종성이 존재할경우 result에 담는다.
						
						resultEng = resultEng + arrJongsungEng[jongsung];
					} 
					
				}else {
					// B. 한글이 아니거나 자음만 있을경우
					
					// 알파벳으로
					
					if(chars>=34127 && chars <= 34147) {
						
						// 단일모음인 경우
						int moum = (chars-34127);
						
						resultEng = resultEng+arrJungsungEng[moum];
					} else {
						// 알파벳인 경우
						
						resultEng = resultEng +((char)(chars)+0xAC00);
						
					}
					
				}// if
				
		}// for
		
		
		
		
		
		
		// 파일명이 겹치지 않게 하기 위해 userLoginId, 현재시간을 경로에 붙여준다.
		// 파일 디렉토리 경로 예: kjk9104_16874828147854/sum.png
		String directoryName = resultEng + "_" + System.currentTimeMillis() + "/";//kjk9104_16874828147854/
		// D:\\kyu\\Spring_project\\memo\\workspace\\images/kjk9104_16874828147854/
		String filePath = FILE_UPLODE_PATH + directoryName;
		
		// 디렉토리 만들기
		File directory = new File(filePath);
		if(directory.mkdir() == false) {
			return null;
		}
		
		// 파일 업로드: byte 단위로 업로드 한다.
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(filePath + file.getOriginalFilename());	// TODO 파일명을 영어로 만들게
			Files.write(path, bytes); //파일 업로드 
			
			// 이미지 업로드 성공시 Path를 리턴한다.(WebMvcConfig에서 매핑한 이미지 path)
			// 예) http://localhost/images/보라돌이_1660209321404/facebook.png
			return "/images/" + directoryName + file.getOriginalFilename(); // TODO 파일명은 Path랑 일치하게
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	public void deleteFile(String imagePath) throws IOException {
		// imagePath = /images/test2_1658477109450/5124630.png
		// "D:\\kyu\\Spring_project\\memo\\workspace\\images/ "
		// 전체 경로와 imagePath간의 중복되는 /images/ 문자영을 제거한 후 실제 저장 경로를 찾는다.
		
		imagePath = imagePath.replace("/images/",""); // /test2_1658477109450/5124630.png
		Path path = Paths.get(FILE_UPLODE_PATH + imagePath);
		if (Files.exists(path)) { // 이미지 파일이 있으면 삭제
			Files.delete(path);
		}
		
		// 디렉토리(폴더) 삭제
		path = path.getParent();
		if(Files.exists(path)) { // 폴더가 있으면 삭제
			Files.delete(path);
		}
		
	}
}
