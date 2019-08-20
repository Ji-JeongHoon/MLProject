package com.ja.reference.service.impl;

import org.springframework.stereotype.Service;

import com.ja.reference.service.SumService;

@Service
public class SumServiceImpl implements SumService {
	
	public int sumProcess(int v1, int v2) {
		
		int result = v1 + v2;
		
		return result;
		
	}

}
