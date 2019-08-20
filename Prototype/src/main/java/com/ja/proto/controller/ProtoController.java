package com.ja.proto.controller;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProtoController {

	@RequestMapping("/testForm")
	public String test() {
		
		
		
		
		return "testForm";
		
	}
	
	@RequestMapping("/dragDropTest")
	public String dragDropTest() {
		
		
		
		return "dragDropTest";
	}
	
	
	
	@RequestMapping("/outputJson")
	   public String outputJson() {
	    
	      
	      String jsonValue = "{\"title\":\"title1\",\"content\":\"content1\"}";
	      
	      try {
	         URL url = new URL("http://localhost/proto/outputResult");
	         HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
	         httpCon.setDoOutput(true);
	         httpCon.setRequestMethod("POST");
	         
	         //보낼때 타입설정
	         httpCon.setRequestProperty("Content-Type", "application/json");
	         
	         
	         //받을때 타입 설정
	         httpCon.setRequestProperty("Accept", "application/json");
	         httpCon.setConnectTimeout(5000); // 서버에 연결되는 Timeout 시간 설정
	         httpCon.setReadTimeout(5000);
	         
	         OutputStream os = httpCon.getOutputStream();
	         os.write(jsonValue.getBytes("UTF-8"));
	         os.flush();
	         
	         BufferedReader in = new BufferedReader(new InputStreamReader(httpCon.getInputStream(), "UTF-8"));
	         
	         
	         //돌려받은 값 찍기.
	         System.out.println(in.readLine());
	         
	         httpCon.disconnect();
	         System.out.println("outputJson 끝");
	         
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	      
	      return null;
	   }
	   
	   @RequestMapping("/outputResult")
	   public String outputResult(@RequestBody Map<String, Object> json, HttpServletResponse response) {
	      System.out.println("outputResult 시작");
	      String result = json.toString();
	      System.out.println(result);
	      
	      String returnJson = "{\"title\":\"title2\",\"content\":\"content2\"}";
	      try {
	         response.getWriter().print(returnJson);
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	      
	      System.out.println("outputResult 끝");
	      return null;
	   }
	   
		
		
		
	}
	

	
	

