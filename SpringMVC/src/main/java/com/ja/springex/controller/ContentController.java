package com.ja.springex.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.ja.springex.service.ContentService;
import com.ja.springex.vo.BoardDataVO;
import com.ja.springex.vo.ContentVO;
import com.ja.springex.vo.SessionDataVO;
import com.ja.springex.vo.UploadFileVO;

@Controller
public class ContentController {

	@Autowired
	private ContentService contentService; 	
	
	@RequestMapping("/")
	public String home(Model model) {
		return boardPage(model,null,null);
	}
	
	
	@RequestMapping("/boardPage")
	public String boardPage(Model model, String searchWord, String searchTarget) {
		
		ArrayList<BoardDataVO> list = contentService.getContentsList(searchWord, searchTarget);
		
		model.addAttribute("boardDataList",list);
		
		return "boardPage";
	}
	
	
	@RequestMapping("/writeContentForm")
	public String writeContentForm() {
		return "writeContentForm";
	}
	
	//MultipartFile 사용하기위한 요구조건.
	//1. pom.xml 관련 라이브러리 있어야함.
	//2. servlet~~~ xml : <annotation-driven/> 이 있어야함.. 기본적으로 있긴함.
	//3. servlet xml 에 : multipartResolver id 로 된 bean 등록되어야함.
	//4.  <form 안에  enctype ="multipart/form-data >  있어야함. "
	
	//5. 주의할것 : publish 할때마다 uploadimg 에 올라간 이미지들이 날라감. 
	
	
	
	@RequestMapping("/writeContentAction")
	public String writeContentAction(MultipartFile [] files, ContentVO requestParam , HttpSession session, HttpServletRequest request) {
		
		ArrayList<UploadFileVO> fileList = new ArrayList<UploadFileVO>();
		
		
		//파일 업로드 처리. 파일도 c_idx 가 필요한데.. c_idx 는 밑에있음.. 어케할까?
		//nextval 부터 호출시켜 가져오고 그걸  다시 넣어줌..
		
		String uploadRootFolderName = request.getSession().getServletContext().getRealPath("/uploadimg/");
		
		
		//System.out.println(uploadRootFolderName);
		
		for(MultipartFile file : files) {
			
			//예외 처리
			if(file.getSize() == 0 )
				continue;
			
			
			String oriFilename = file.getOriginalFilename();			
			
			//중복 파일 명 제거 위해 파일명 바꾸기. 랜덤하게
			String randomFilename = UUID.randomUUID().toString();
			
			randomFilename += oriFilename.substring(oriFilename.lastIndexOf('.'));
			
			
			System.out.println("저장될 파일 명 : "+uploadRootFolderName + randomFilename);
			
			
			
			//저장.
			
			try {
				file.transferTo(new File(uploadRootFolderName + randomFilename));
			} catch (Throwable e) {
				e.printStackTrace();
			}
			
			//DATA 생성
			
			String link = request.getContextPath();
			
			link += "/uploadimg/";

			link += randomFilename;
			
			UploadFileVO fileVO = new UploadFileVO(null,null,link,oriFilename);
			
			fileList.add(fileVO);
			
		}
		
		
		
		
		
		//Data 처리
		SessionDataVO sessionData = 
				(SessionDataVO)session.getAttribute("sessionData");
		
		String m_idx = sessionData.getM_idx();
		
		requestParam.setM_idx(m_idx);
		
		
		contentService.writeContent(requestParam, fileList);
		
		return "redirect:boardPage";
	}
	
	
	
	
	
	@RequestMapping("/readContentPage")
	public String readContentPage(ContentVO requestParam,Model model) {
		
		BoardDataVO boardData = contentService.readContent(requestParam);
		
		model.addAttribute("boardData" , boardData);
		
		
		return "readContentPage";
	}
	
	
	
	
	
	@RequestMapping("/deleteContentAction")
	public String deleteContentAction(String c_idx) {
		
		ContentVO vo = new ContentVO();
		vo.setC_idx(c_idx);
		
		contentService.deleteContent(vo);
		
		return "redirect:boardPage";
	}
	
	@RequestMapping("/updateContentForm")
	public String updateContentForm(ContentVO requestParam, Model model) {
		
		BoardDataVO data = contentService.readContent(requestParam);
		
		model.addAttribute("boardData", data);
		
		return "updateContentForm";
	}
	
	@RequestMapping("/updateContentAction")
	public String updateContentAction(ContentVO requestParam) {
		
		
		contentService.updateContent(requestParam);
		
		
		return "redirect:boardPage";
	}
	
	@RequestMapping("/testAction")
	public String testAction() {
		try {
			ServerSocket serversock = new ServerSocket(8765);
			System.out.println("클라이언트 접속 대기중..");
			Socket socket = serversock.accept();
			System.out.println("클라이언트 접속 !!");
			
			BufferedReader in = new BufferedReader(
								new InputStreamReader(
										
										socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
			
			String rev = in.readLine();
			System.out.println("Received : " + rev);
			out.println("Echo : " + rev);
			System.out.println("Send : " + rev);
			socket.close();
			serversock.close();
			
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		return null;
		
		
		
	}
	
	
}



















