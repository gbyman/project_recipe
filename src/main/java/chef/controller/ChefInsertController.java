package chef.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import allmember.model.AllMember;
import chef.model.Chef;
import chef.model.ChefDao;

@Controller
public class ChefInsertController {
	
	private static final String getPage = "ChefInsertForm";
	private static final String gotoPage = "redirect:/list.cf";
	private static final String command = "/insert.cf";
	
	@Autowired
	private ChefDao chefDao;
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doActionGet(HttpSession session) {
		
		System.out.println(this.getClass() + "Get방식 들어옴");
		System.out.println("loginInfo : " + session.getAttribute("loginInfo"));
		//loginInfo session 설정 : AllMemberLoginController(로그인 버튼 클릭)
		
		//로그인 안하면 먼저 로그인
		if(session.getAttribute("loginInfo") == null) {
			
			session.setAttribute("destination", "redirect:/insert.cf");
			return "redirect:/login.mem";
		
		} else { //세션 연결 되어 있다면 ChefInsertForm.jsp로 이동
			
			return getPage;
		}//if ~ else
		
	}
	
	//데이터 db에 입력하고 페이지 이동
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doActionPost(@ModelAttribute("chef") @Valid Chef chef,
			BindingResult bindingResult, HttpSession session) {
		
		System.out.println(this.getClass() + "POST방식 들어옴");
		
		ModelAndView mav = new ModelAndView();
		
		System.out.println("servletContext.getRealPath('/')" + servletContext.getRealPath("/"));
		//C:\project\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Project_AllRecipe\
		
		String uploadPath = servletContext.getRealPath("/resources/chef/");
		// C:\project\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Project_AllRecipe\resources\chef\
		
		//세션에서 id값 가져와서 작성자에 입력 : 참조값으로 설정되어으므로 id값 사용
		System.out.println("sessionloginInfo : " + session.getAttribute("loginInfo"));
		System.out.println("session id : " + session.getAttribute("id"));
		AllMember writer = new AllMember();
		writer = (AllMember)session.getAttribute("loginInfo");
		System.out.println("writer.getId() : " +  writer.getId());
		
		chef.setWriter(writer.getId());
		
		//유효성 검사 항목 출력 및 데이터가 제대로 있는지 확인
		
		System.out.println("chef.getChefnum() : " + chef.getChefnum());
		System.out.println("chef.getWriter() : " + chef.getWriter());
		System.out.println("chef.getCsubject() : " + chef.getCsubject());
		System.out.println("chef.getCshortintro() : " + chef.getCshortintro());
		System.out.println("chef.getCingredient() : " + chef.getCingredient());
		System.out.println("chef.getCintro() : " + chef.getCintro());
		System.out.println("chef.getCmainimage() : " + chef.getCmainimage());
		System.out.println("chef.getCimage1() : " + chef.getCimage1());
		System.out.println("chef.getCimage2() : " + chef.getCimage2());
		System.out.println("chef.getCimage3() : " + chef.getCimage3());
		System.out.println("chef.getCimage4() : " + chef.getCimage4());
		
		if(bindingResult.hasErrors()) {
			
			System.out.println("Chef InsertController 유효성 검사 오류");
			
			mav.setViewName(getPage);//오류 있으면 ChefInsertForm.jsp로 이동
			return mav;
			
		}
		
		ArrayList<MultipartFile> multi = new ArrayList<MultipartFile>();
		multi.add(chef.getUploadcmainimage());
		multi.add(chef.getUploadcimage1());
		multi.add(chef.getUploadcimage2());
		multi.add(chef.getUploadcimage3());
		multi.add(chef.getUploadcimage4());
		
		System.out.println("chef multi.size() : " + multi.size());
		//multi에 몇장의 이미지가 담겨 있는지 확인
		
		Integer cnt = -1;
		cnt = chefDao.InsertData(chef);
		
		if(cnt != -1) {//업로드 성공
			
			mav.setViewName(gotoPage); //redirect:/list.cf
			
			//multi에 담겨있는 사진 한개씩 꺼내서 처리
			
			for(int i = 0 ; i < multi.size(); i++) {
				
				File destination = new File(uploadPath + File.separator + multi.get(i).getOriginalFilename());
				// C:\project\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Project_Allrecipe\resources\chef\사진이름.jpg
				
				try {
					multi.get(i).transferTo(destination);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}//End of for
			System.out.println("Chef 이미지 업로드 성공");
		} else { //업로드 실패
			
			System.out.println("업로드 실패");
			mav.setViewName(getPage);//ChefInsertForm.jsp
		} // if ~ else
		
		return mav;
	}//public ModelAndView doActionPost()

}
