package com.ja.proto;

/**
java http 접속 API 

HttpURLConnection << 사용법 검색 하면 많이 나올꺼여요 .... 

 - get 방식 및 url 파라미터 방식으로도 충분 하겠지만 json 방식으로 던져야 겠다 싶으면 

검색에 "HttpURLConnection JSON" 으로 검색하면 많이 나올듯.

네이버에 request 날리고 결과 받는 코드..
====================================코드====================================== */

import java.io.*;
import java.net.*;

public class HttpAPI {

   public static void main(String[] args) throws Exception {
      // TODO Auto-generated method stub
      
      URL url = new URL("https://www.naver.com");
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      con.setConnectTimeout(5000); // 서버에 연결되는 Timeout 시간 설정
      con.setReadTimeout(5000); // InputStream 읽어 오는 Timeout 시간 설정
      //con.addRequestProperty("x-api-key", RestTestCommon.API_KEY); // key값 설정
      
      con.setRequestMethod("GET");

      
      //URLConnection에 대한 doOutput 필드값을 지정된 값으로 설정한다. URL 연결은 입출력에 사용될 수 있다. URL 연결을 출력용으로 사용하려는 경우 DoOutput 플래그를 true로 설정하고, 그렇지 않은 경우는 false로 설정해야 한다. 기본값은 false이다.
      con.setDoOutput(false);
      
      StringBuilder sb = new StringBuilder();
      if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
         // Stream을 처리해줘야 하는 귀찮음이 있음.
         BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
         String line;
         
         while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
         }
         
         br.close();
         System.out.println("" + sb.toString());
      }
   }   
}







