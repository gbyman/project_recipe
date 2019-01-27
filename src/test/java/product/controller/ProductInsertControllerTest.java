package product.controller;


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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import allmember.model.AllMember;
import product.model.ProductDao;

@RunWith(MockitoJUnitRunner.class)
public class ProductInsertControllerTest {
	
	@Mock
	private ProductDao productDao;
	
	@InjectMocks
	ProductInsertController productInsertController;
	
	@Autowired
	MockHttpServletRequest request;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() throws Exception{
		this.mockMvc = MockMvcBuilders.standaloneSetup(productInsertController).build();
	}
	
	@Test//ProductInsertController get방식 검증 : 테스트 통과
	public void testDoActionGet() throws Exception {
		//세션 설정
		MockHttpSession session = new MockHttpSession();
		AllMember member = new AllMember();
		member.setId("dong");
		session.setAttribute("loginInfo", member);
		
		this.mockMvc
			.perform(get("/insert.mt").session(session))//get방식,세션연결
			.andExpect(status().isOk())//200 : 오류없이 전송성공
			.andDo(print())//콘솔창에 데이터 출력
			.andExpect(forwardedUrl("ProductInsertForm"));//RecipeInsertForm.jsp로 이동예상
	}
	

}