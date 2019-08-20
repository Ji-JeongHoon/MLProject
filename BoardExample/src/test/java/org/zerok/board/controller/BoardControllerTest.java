package org.zerok.board.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes= {org.zerok.board.config.RootConfig.class,
		org.zerok.board.config.ServletConfig.class})
@Log4j
public class BoardControllerTest {
	private static final String UD_TARGET_ID = "5555";
	
	@Setter(onMethod_ = @Autowired)
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testGetListWithPaging() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/board/list");
		requestBuilder.param("curPage", "5");
		requestBuilder.param("pageSize", "10");
		
		ResultActions resultActions = mockMvc.perform(requestBuilder);
		MvcResult mvcResult = resultActions.andReturn();
		ModelAndView modelAndView = mvcResult.getModelAndView();
		ModelMap modelMap = modelAndView.getModelMap();
		log.info(modelMap);
	}
/*
	@Test
	public void testGetList() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/board/list");
		
		ResultActions resultActions = mockMvc.perform(requestBuilder);
		MvcResult mvcResult = resultActions.andReturn();
		ModelAndView modelAndView = mvcResult.getModelAndView();
		ModelMap modelMap = modelAndView.getModelMap();
		log.info(modelMap);
	}


	@Test
	public void testGet() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/board/get");
		requestBuilder.param("id", UD_TARGET_ID);
		
		ResultActions resultActions = mockMvc.perform(requestBuilder);
		MvcResult mvcResult = resultActions.andReturn();
		ModelAndView modelAndView = mvcResult.getModelAndView();
		ModelMap modelMap = modelAndView.getModelMap();
		log.info(modelMap);
	}

	@Test
	public void testInsert() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/board/insert");
		requestBuilder.param("title", "srdftgasdfgasf");
		requestBuilder.param("contents", "aswreygserhgsaefhsdfg");
		requestBuilder.param("writer", "홍길동");
		
		ResultActions resultActions = mockMvc.perform(requestBuilder);
		MvcResult mvcResult = resultActions.andReturn();
		ModelAndView modelAndView = mvcResult.getModelAndView();
		String resultPage= modelAndView.getViewName();
		log.info("\n---------------"  + resultPage);
	}

	@Test
	public void testUpdate() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/board/update");
		requestBuilder.param("id", UD_TARGET_ID);
		requestBuilder.param("title", "srdftgasdfgasf");
		requestBuilder.param("contents", "aswreygserhgsaefhsdfg");
		requestBuilder.param("writer", "홍길동");
		
		ResultActions resultActions = mockMvc.perform(requestBuilder);
		MvcResult mvcResult = resultActions.andReturn();
		ModelAndView modelAndView = mvcResult.getModelAndView();
		String resultPage= modelAndView.getViewName();
		log.info("\n---------------"  + resultPage);
	}

	@Test
	public void testDelete() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/board/delete");
		requestBuilder.param("id", UD_TARGET_ID);
		
		ResultActions resultActions = mockMvc.perform(requestBuilder);
		MvcResult mvcResult = resultActions.andReturn();
		ModelAndView modelAndView = mvcResult.getModelAndView();
		String resultPage= modelAndView.getViewName();
		log.info("\n---------------"  + resultPage);
	}
*/
}
