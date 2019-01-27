package recipe.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import allmember.model.AllMember;
import recipe.model.Recipe;
import recipe.model.RecipeDao;

@Controller
public class RecipeInsertController {
	
	private static final String getPage = "RecipeInsertForm";
	private static final String command = "/insert.rec";
	
	@Autowired
	private RecipeDao recipeDao;
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doActionGet(HttpSession session) {
		
		System.out.println(this.getClass() + "Get방식 들어옴");
		System.out.println("loginInfo : " + session.getAttribute("loginInfo"));
		//loginfo session 설정 : AllMemberLoginController(로그인 버튼 클릭)
		
		//로그인이 되어있지 않으면 로그인 하도록 페이지 이동
		if(session.getAttribute("loginInfo") == null) {
			
			session.setAttribute("destination", "redirect:/insert.rec");// destination = "redirect:/insert.rec"
			return "redirect:/login.mem";
			
		} else {//세션 연결 되어있다면 RecipeInsertForm.jsp로 이동
			
			return getPage;
			
		}//else 
		
	}//
	
	//데이터 db에 입력하고 페이지 이동
	@RequestMapping(value = command, method = RequestMethod.POST)
	public void doActionPost(@ModelAttribute("recipe") @Valid Recipe recipe, 
			BindingResult bindingResult, HttpSession session,HttpServletResponse response,HttpServletRequest request) throws IOException {
		
		System.out.println(this.getClass() + "POST방식 들어옴" );
		
		PrintWriter writer=null;
		response.setContentType("text/html;charset=UTF-8");
		writer=response.getWriter();
		String contextPath=request.getContextPath();
		
		AllMember member = new AllMember();
		member = (AllMember)session.getAttribute("loginInfo");
		String uploadPath = servletContext.getRealPath("/resources/recipe/"+member.getId()+"Recipe");
		System.out.println(uploadPath);
		recipe.setWriter(member.getId());
				
		//유효성 검사 항목 출력 및 데이터가 제대로 있는지 확인
		System.out.println(member);
		if(member==null) {
			writer.println("<script type='text/javascript'>");
			writer.println("alert('로그인을 해야합니다.')");
			writer.println("location.href='"+contextPath+"/login.mem'");
			writer.println("</script>");
			writer.flush();
			writer.close();
		}
		
		if(bindingResult.hasErrors()) {
			
			System.out.println("InsertController 유효성 검사 오류");
			
			writer.println("<script type='text/javascript'>");
			writer.println("alert('다시 입력해주세요.')");
			writer.println("history.back()");
			writer.println("</script>");
			writer.flush();
			writer.close();
		}
		if(recipe.getUploadmainimage().getSize()==0) {
			recipe.setMainimage("basicRecipe.jpg");
		}
		if(recipe.getMovieurl().length()>0) {
			recipe.setMovieurl(recipe.getMovieurl().substring(17, 28));
		}
		ArrayList<MultipartFile> multi = new ArrayList<MultipartFile>();
		multi.add(recipe.getUploadmainimage());
		multi.add(recipe.getUploadimage1());
		multi.add(recipe.getUploadimage2());
		multi.add(recipe.getUploadimage3());
		multi.add(recipe.getUploadimage4());
		
		System.out.println("multi.size() : " + multi.size()); 
		//multi에 몇 장의 이미지가 담겨 있는 지 확인
		
		Integer cnt = -1;
		cnt = recipeDao.InsertData(recipe);
		
		if(cnt != -1) { //업로드 성공
			
			File dir=new File(uploadPath);
			if(!dir.exists()) {
				dir.mkdir();
			}
			// multi에 담겨있는 사진 한개씩 꺼내서 처리
			for (MultipartFile mul: multi) {
				if(mul.getSize()!=0) {
					File up = new File(uploadPath + File.separator + mul.getOriginalFilename());
					
					try {
						mul.transferTo(up);
					} catch(IllegalStateException e) {
						e.printStackTrace();
					} catch(IOException e) {
						e.printStackTrace();
					}
				}
				
			}//End of for
			System.out.println("업로드 성공");
			writer.println("<script type='text/javascript'>");
			writer.println("alert('등록되었습니다.')");
			writer.println("location.href='"+contextPath+"/list.rec'");
			writer.println("</script>");
			writer.flush();
			writer.close();
			
		} else {//업로드 실패
			System.out.println("업로드 실패");	
			writer.println("<script type='text/javascript'>");
			writer.println("alert('등록에 실패했습니다.')");
			writer.println("history.back()");
			writer.println("</script>");
			writer.flush();
			writer.close();
		} 
		
		
		
	}//public ModelAndView doActionPost()

}
