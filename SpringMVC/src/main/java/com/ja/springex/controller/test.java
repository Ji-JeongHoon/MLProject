package com.ja.springex.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket serversock = new ServerSocket(9009);
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
		
		

	}

}
