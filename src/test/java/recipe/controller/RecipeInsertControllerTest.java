package recipe.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
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
import org.springframework.web.servlet.ModelAndView;

import allmember.model.AllMember;
import recipe.model.Recipe;
import recipe.model.RecipeDao;

//Note :Spring mvc test(Controller Unit Test) 구현
//DEV : 단위테스트 구현해야함 

@RunWith(MockitoJUnitRunner.class)
public class RecipeInsertControllerTest {
	
	@Mock
	private RecipeDao recipeDao;
	
	@InjectMocks
	RecipeInsertController recipeInsertController;
	
    @Autowired 
    MockHttpServletRequest request;
	
	private MockMvc mockMvc;

	@Before//recipeInsertController를 mockMvc객체로 만든다
	public void setup() throws Exception{
		this.mockMvc = MockMvcBuilders.standaloneSetup(recipeInsertController).build();
	}
	
/*	@Test//RecipeInsertController 중에서 get방식 테스트 : 테스트 통과
	public void testDoActionGet() throws Exception{
		
		//세션 설정
		MockHttpSession session = new MockHttpSession();
		AllMember member = new AllMember();
		member.setId("dong");
		session.setAttribute("loginInfo", member);
		
		this.mockMvc
			.perform(get("/insert.rec").session(session))//get방식,세션연결
			.andExpect(status().isOk())//200 : 오류없이 전송성공, 상태값은 ok
			.andDo(print())//콘솔창에 처리내용 출력
			.andExpect(forwardedUrl("RecipeInsertForm"));//RecipeInsertForm.jsp로 이동예상
	}*/

	
	@Test//RecipeInsertController 중에서 post방식 테스트 : (Note : 테스트 코드 불량) 
	public void testDoActionPost() throws Exception {
		
		//세션 및 기타 설정
		MockHttpSession session = new MockHttpSession();
		AllMember member = new AllMember();
		member.setId("dong");
		session.setAttribute("loginInfo", member);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/list.rec");
		
		
		this.mockMvc
			.perform(post("/insert.rec").session(session)
					.flashAttr("recipe", new Recipe())
					.param("recnum", "1")
					.param("writer",session.getId())
					.param("psubject", "psubject")
					.param("theme", "1")
					.param("shortintro", "short")
					.param("ingredient", "ingredient")
					.param("movieurl", "movieurl")
					.param("intro", "intro")
					.param("mainimage", "mainimage")
					.param("image1", "image1")
					.param("image2", "image2")
					.param("image3", "image3")
					.param("image4", "image4")
					
					)
			
			.andDo(print())
			.andExpect(model().hasNoErrors())
			.andExpect(status().isMovedTemporarily())
			.andExpect(redirectedUrl("/list.rec"));
		//.flashAttr("exampleEntity", new ExampleEntity())
	}


}
