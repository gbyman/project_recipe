package recipe.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import recipe.model.Recipe;
import recipe.model.RecipeDao;

@Controller
public class RecipeUpdateController {
	
	private static final String command = "/update.rec";
	private static final String gotoPage = "redirect:/list.rec";
	private static final String getPage = "RecipeUpdateForm";
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private RecipeDao recipeDao;
	
	//RecipeDetailViewList.jsp에서 수정하기 누르면  GET방식으로 넘어온다
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doActionGet(HttpSession session, @RequestParam(value = "recnum", required = true) int recnum, Model model) {
		
		//로그인 안한 사람이 수정하기 누르면 로그인 화면으로 이동
		if(session.getAttribute("loginInfo") == null) {
			
			session.setAttribute("destination", "redirect:/update.rec?recnum="+recnum);
			return "redirect:login.mem";
		
		} else { //로그인 되어 있다면 RecipeUpdateForm.jsp로 이동
			
			Recipe recipe = recipeDao.GetData(recnum);
			System.out.println("recipe.theme : " + recipe.getTheme());
			
			model.addAttribute("recipe", recipe);
			return getPage;
			
		}//if~else
		
	}
		//RecipeUpdateForm.jsp에서 post방식으로 넘어옴
		@RequestMapping(value = command, method = RequestMethod.POST)
		public ModelAndView doActionPost(Recipe recipe) {
			
			System.out.println("RecipeUpdateController Post방식");
			
			//사진을 MultipartFile 형식의 multi라는 곳에 담았다 
			ArrayList<MultipartFile> multi = new ArrayList<MultipartFile>();
		
			multi.add(recipe.getUploadmainimage());
			multi.add(recipe.getUploadimage1());
			multi.add(recipe.getUploadimage2());
			multi.add(recipe.getUploadimage3());
			multi.add(recipe.getUploadimage4());
		
			
			//이미지가 저장되어 있는 폴더
			String uploadDir = servletContext.getRealPath("/resources/recipe/");
			System.out.println("RecipeUpdateController uploadDir : "+ uploadDir);
			
			File delMainImageFile = new File(uploadDir + File.separator + recipe.getMainimage());
			File delImg1File = new File(uploadDir + File.separator + recipe.getImage1());
			File delImg2File = new File(uploadDir + File.separator + recipe.getImage2());
			File delImg3File = new File(uploadDir + File.separator + recipe.getImage3());
			File delImg4File = new File(uploadDir + File.separator + recipe.getImage4());
			
			ModelAndView mav = new ModelAndView();
												
			Integer cnt = -1;
			cnt = recipeDao.UpdateData(recipe);
			System.out.println(cnt);
			//수정 성공
			if(cnt != -1) {
				//DEV :  기존 이미지 파일 5장 일일이 지우는 법에서 한번에 지울 수 있게 해야 함
				
				//수정 성공 후 기존의 이미지 삭제
				boolean main=delMainImageFile.delete();
				System.out.println(main);
				delImg1File.delete();
				delImg2File.delete();
				delImg3File.delete();
				delImg4File.delete();
				
				//기존 이미지 삭제 후 새로 수정한 파일을 파일이름으로 이미지 저장 폴더에 저장
				for(int i = 0 ; i < multi.size() ; i++) {
					
					System.out.println("multisize() : " + multi.size());
					
					File destination = new File(uploadDir + File.separator + multi.get(i).getOriginalFilename());
					System.out.println("upload destination : " + destination);
					
					try {
						multi.get(i).transferTo(destination);
					} catch(IllegalStateException e) {
						e.printStackTrace();
						System.out.println("recipeupdate ISE");
					} catch(IOException e) {
						e.printStackTrace();
						System.out.println("recipeupdate IOException");
					}
					
				}//for문의 끝
				
				mav.setViewName(gotoPage);// 기존 이미지 삭제하고 redirect:/list.rec 로 이동 
				
				
			} else { //수정 실패 후 RecipeUpdateForm.jsp로 다시 이동
				
				mav.setViewName(getPage);// RecipeUpdateForm.jsp로 이동
				
			}//if~else
			
			return mav;
		
	}

}
