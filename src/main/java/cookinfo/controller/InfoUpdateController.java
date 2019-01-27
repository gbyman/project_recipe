package cookinfo.controller;

import java.io.File;
import java.io.IOException;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cookinfo.model.CookInfo;
import cookinfo.model.CookInfoDao;


@Controller
public class InfoUpdateController implements ServletContextAware{
	private static final String command="/infoupdate.bod";
	private static final String getPage="InfoUpdateForm";
	private static final String gotoPage="redirect:/infolist.bod";

	private ServletContext servletContext;
	
	@Autowired
	@Qualifier("MyCookInfoDao")
	private CookInfoDao cdao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String goUpdateForm(
			@RequestParam(value="infokind",required=false) String infokind,
			@RequestParam("infonum") int infonum,
			@RequestParam("pageNumber") int pageNumber,
			Model model
			) {
		CookInfo cookinfo=cdao.selectByNum(infonum);
		
		model.addAttribute("cookinfo", cookinfo);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("infokind", infokind);
		return getPage;
	}
	

	
	
	@RequestMapping(value=command , method=RequestMethod.POST)
	public ModelAndView doActionPost(CookInfo cookinfo,
			@RequestParam(value="infokind",required=false) String infokind,
			@RequestParam("pageNumber") int pageNumber,HttpServletResponse response) throws IOException{		
		
		System.out.println("post 방식 들어옴");
  
		MultipartFile multi = cookinfo.getUpload();
		ModelAndView mav = new ModelAndView();
		if(multi.getSize()==0) {
			cookinfo.setInfoimage(cookinfo.getUpload2());
		}
		
		String uploadDir=servletContext.getRealPath("/resources");
		System.out.println("PUCon uploadDir : "+uploadDir);
		
		Integer cnt = -1;
		cnt = cdao.UpdateData(cookinfo);	
		
		if (cnt != -1) { 
			if(multi.getSize()!=0) {
				File destination = new File( uploadDir + File.separator +multi.getOriginalFilename() ); // Penguin.jpg
				File destination2 = new File( uploadDir + File.separator +cookinfo.getUpload2() ); //기존 화일 
	
				destination2.delete(); // 해당 폴더에서 화일 지우기
				
				
				try {
					multi.transferTo(destination);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			mav.setViewName(gotoPage+"?infokind="+cookinfo.getInfokind()+"&pageNumber="+pageNumber);
			
		} else {
			mav.setViewName(getPage);
		}
		
		
		
		return mav;

	}

	@Override
	public void setServletContext(ServletContext context) {
		// TODO Auto-generated method stub
		servletContext=context;		
	}
}
