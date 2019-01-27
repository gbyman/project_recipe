package chef.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
//import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import allmember.model.AllMember;
import chef.model.ChefDao;

@RunWith(MockitoJUnitRunner.class)
public class ChefInsertControllerTest {

	@Mock
	private ChefDao chefDao;
	
	@InjectMocks
	ChefInsertController chefInsertController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() throws Exception{
		this.mockMvc = MockMvcBuilders.standaloneSetup(chefInsertController).build();
	}
	
	@Test
	public void testDoActionGet() throws Exception{
		//세션 설정
		MockHttpSession session = new MockHttpSession();
		AllMember member = new AllMember();
		member.setId("dong");
		session.setAttribute("loginInfo", member);
		
		this.mockMvc
			.perform(get("/insert.cf").session(session))//get방식,세션연결
			.andExpect(status().isOk())//200 : 오류없이 전송성공
			.andDo(print())//콘솔창에 데이터 출력
			.andExpect(forwardedUrl("ChefInsertForm"));//ChefInsertForm.jsp로 이동예상
	}

}
