package chef.controller;

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

import chef.model.Chef;
import chef.model.ChefDao;

@Controller
public class ChefUpdateController {
	
	private static final String command ="/update.cf";
	private static final String gotoPage = "redirect:/list.cf";
	private static final String getPage = "ChefUpdateForm";
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private ChefDao chefDao;
	
	//ChefDetailViewList.jsp에서 수정하기 누르면 GET방식으로 넘어온다
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doActionGet(HttpSession session, @RequestParam(value="chefnum", required = true) int chefnum, Model model) {
		
		//로그인 되어 있는지 확인
		if(session.getAttribute("loginInfo") == null) {
			
			session.setAttribute("destination", "redirect:/update.cf?chefnum="+chefnum);
			return "redirect:login.mem";
			
		} else { //로그인 되어 있다면 ChefUpdateForm.jsp로 이동
			
			Chef chef = chefDao.GetData(chefnum);
			System.out.println("chef.csubject : " + chef.getCsubject());
			
			model.addAttribute("chef", chef);
			return getPage;
			
		}//if ~ else
		
	}//
	
	//ChefUpdateForm.jsp에서 post방식으로 넘어옴
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doActionPost(Chef chef) {
		
		System.out.println("ChefUpdateController Post방식");
		
		//이미지 담는 과정
		ArrayList<MultipartFile> multi = new ArrayList<MultipartFile>();
		
		multi.add(chef.getUploadcmainimage());
		multi.add(chef.getUploadcimage1());
		multi.add(chef.getUploadcimage2());
		multi.add(chef.getUploadcimage3());
		multi.add(chef.getUploadcimage4());
		
		//이미지가 저장되어 있는 폴더
		String uploadDir = servletContext.getRealPath("/resources/chef/");
		System.out.println("ChefUpdateController uploadDir : "+ uploadDir);
		
		File delCmainImageFile = new File(uploadDir + File.separator + chef.getCmainimage());
		File delCimg1File = new File(uploadDir + File.separator + chef.getCimage1());
		File delCimg2File = new File(uploadDir + File.separator + chef.getCimage2());
		File delCimg3File = new File(uploadDir + File.separator + chef.getCimage3());
		File delCimg4File = new File(uploadDir + File.separator + chef.getCimage4());
		
		ModelAndView mav = new ModelAndView();
		
		Integer cnt = -1;
		cnt = chefDao.UpdateData(chef);
		System.out.println(cnt);
		
		//수정 성공
		if(cnt != -1) {
			//DEV :  기존 이미지 파일 5장 일일이 지우는 법에서 한번에 지울 수 있게 해야 함
			
			//수정 성공 후 기존의 이미지 삭제
			
			delCmainImageFile.delete();
			delCimg1File.delete();
			delCimg2File.delete();
			delCimg3File.delete();
			delCimg4File.delete();
			
			//기존 이미지 삭제 후 새로 수정한 파일을 파일이름으로 이미지 저장 폴더에 저장
			
			for(int i = 0; i < multi.size() ; i++) {
				
				System.out.println("chefmultisize() : "+ multi.size());
				
				File destination = new File(uploadDir + File.separator +  multi.get(i).getOriginalFilename());
				System.out.println("chef upload destination : " + destination);
				
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
			
			mav.setViewName(gotoPage);//기존 이미지 삭제하고 redirect:/list.cf로 이동
			
		} else { //수정 실패 후 ChefUpdateForm.jsp로 다시 이동
			
			mav.setViewName(getPage); //ChefUpdateForm.jsp 이동
		}//if ~ else
		
		return mav;
		
	}//public ModelAndView doActionPost(Chef chef)
}
