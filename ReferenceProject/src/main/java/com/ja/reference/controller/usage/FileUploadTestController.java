package com.ja.reference.controller.usage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadTestController {

	@RequestMapping("/fileUploadForm")
	public String fileUploadForm() {
		
		
		return "fileUploadForm";
	}
	
	
	
	@RequestMapping("/fileUploadAction")//파일이 두개이상 날아올수 있기 때문에 배열로 받음
	public String fileUploadAction(MultipartFile[] files) {
		
		String rootFolderName = "C:\\upload\\";
		
		//날짜별 폴더 확인 및 생성..
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String dateFolder = sdf.format(date);
		dateFolder = dateFolder.replace("-", File.separator);
		
		File uploadPath = new File(rootFolderName, dateFolder);
		
		
		
		if(!uploadPath.exists()) {
			
			uploadPath.mkdirs(); //폴더 만들기
			
		}
		
		
		
		
		
		//파일처리 ...외부 라이브러리 가져올수밖에 없음.
		for (MultipartFile file : files) {
			
			String oriFileName = file.getOriginalFilename();
			System.out.println("넘어온 파일 명 : "+ oriFileName);
			
			//아주 큰 값으로 랜덤하게 만듦 
			UUID uuid = UUID.randomUUID();
			String uploadFileName = uuid.toString();//랜덤하게 파일 이름 바꾸기 
			
			
			uploadFileName =  uploadFileName + oriFileName.substring(oriFileName.lastIndexOf('.'));
			
			
			
			try {
				file.transferTo(new File(uploadPath,uploadFileName));
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
		
		
		
		return "test";
	}
	
	
	
	
	
	
	
}
