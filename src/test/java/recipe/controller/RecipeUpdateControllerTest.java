package recipe.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
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

//Note : Spring mvc test(Controller Unit Test) 구현
//DEV : 단위테스트 구현해야함
@RunWith(MockitoJUnitRunner.class)
public class RecipeUpdateControllerTest {
	
	@Mock
	private RecipeDao recipeDao;
	
	@InjectMocks
	RecipeUpdateController recipeUpdateController;
	
	@Autowired 
	MockHttpServletRequest request;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() throws Exception{
		this.mockMvc = MockMvcBuilders.standaloneSetup(recipeUpdateController).build();
	}
	
	@Test//RecipeUpdateController 중에서 get방식 테스트
	public void testDoActionGet() throws Exception{
		
		//세션  설정
		MockHttpSession session = new MockHttpSession();
		AllMember member = new AllMember();
		member.setId("dong");
		session.setAttribute("loginInfo", member);
		
		this.mockMvc
			.perform(get("/update.rec?recnum={val}","9").session(session)
					.param("writer", "dong")
					.param("theme", "1")
					.param("psubject", "psubject")
					.param("intro", "intro"))//get방식,세션연결
			.andExpect(model().size(1))
			.andExpect(model().hasNoErrors())
			.andExpect(status().isOk())//200 : 오류없이 전송성공
			.andDo(print())//콘솔창에 데이터 출력
			.andExpect(forwardedUrl("RecipeUpdateForm"));//RecipeUpdateForm.jsp로 이동예상
		
	}
	
/*	@Test
	public void testDoActionPost() throws Exception{
		
		//세션 및 기타 설정
		MockHttpSession session = new MockHttpSession();
		AllMember member = new AllMember();
		member.setId("dong");
		session.setAttribute("loginInfo", member);
		
		MockMultipartFile mockmainimage = new MockMultipartFile("file", "orig", null, "bar".getBytes());
		MockMultipartFile mockimage1 = new MockMultipartFile("file", "orig", null, "bar".getBytes());
		MockMultipartFile mockimage2 = new MockMultipartFile("file", "orig", null, "bar".getBytes());
		MockMultipartFile mockimage3 = new MockMultipartFile("file", "orig", null, "bar".getBytes());
		MockMultipartFile mockimage4= new MockMultipartFile("file", "orig", null, "bar".getBytes());
		MockMultipartFile mockimage5 = new MockMultipartFile("file", "orig", null, "bar".getBytes());
		MockMultipartFile mockimage6 = new MockMultipartFile("file", "orig", null, "bar".getBytes());
		
		this.mockMvc.perform(post("/update.rec").session(session)
					.param("writer", "dong")
					.param("theme", "1")
					.param("psubject", "psubject")
					.param("intro", "intro"))//get방식,세션연결
				.andDo(print())
				.andExpect(model().size(1))
				.andExpect(status().isMovedTemporarily())
				.andExpect(redirectedUrl("/list.rec"));
		
	}*/

}
