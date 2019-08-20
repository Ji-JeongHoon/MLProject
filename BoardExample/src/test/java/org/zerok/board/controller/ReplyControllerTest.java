package org.zerok.board.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.zerok.board.domain.ReplyVO;

import com.google.gson.Gson;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes= {org.zerok.board.config.RootConfig.class,
		org.zerok.board.config.ServletConfig.class})
@Log4j
public class ReplyControllerTest {
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
		ReplyVO reply = new ReplyVO();
		reply.setPid(3);
		reply.setContents("rest 방식 연동 테스트");
		reply.setWriter("헝길덩");
		
		String strReply = new Gson().toJson(reply);
		
		ResultActions resultActions = mockMvc.perform(post("/replies/new")
				.contentType(MediaType.APPLICATION_JSON)
				.content(strReply));
		resultActions.andExpect(status().is(200));
	}
}
