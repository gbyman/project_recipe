package recipe.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import allmember.model.AllMember;
import recipe.model.RecipeDao;

@RunWith(MockitoJUnitRunner.class)
public class RecipeDeleteControllerTest {
	
	@Mock
	private RecipeDao recipeDao;
	
	@InjectMocks
	RecipeDeleteController recipeDeleteController;
	
	@Autowired 
	MockHttpServletRequest request;
	
	private MockMvc mockMvc;
	
	@Before 
	public void setup() throws Exception{
		this.mockMvc = MockMvcBuilders.standaloneSetup(recipeDeleteController).build();
	}
	
	@Test
	public void testDoActionGet() throws Exception{
		
		//세션 설정
		MockHttpSession session = new MockHttpSession();
		AllMember member = new AllMember();
		member.setId("dong");
		session.setAttribute("loginInfo", member);
		
		this.mockMvc.perform(get("/delete.rec?recnum=9").session(session))
			.andExpect(status().isOk())//200 : 오류없이 전송성공
			.andDo(print())
			.andExpect(redirectedUrl("/redirect/list.rec"));
	}

}
