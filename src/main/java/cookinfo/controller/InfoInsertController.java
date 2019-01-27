package cookinfo.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cookinfo.model.CookInfo;
import cookinfo.model.CookInfoDao;

@Controller
public class InfoInsertController implements  ServletContextAware {
	private static final String command="/infoinsert.bod";
	private static final String	getPage="InfoInsert";
	private static final String	gotoPage="redirect:/infolist.bod";
	

	@Autowired
	@Qualifier("MyCookInfoDao")
	private CookInfoDao cdao;
	
	  ServletContext servletContext;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String goInsertForm() {
		return getPage;
	}
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	public ModelAndView goInsert(CookInfo cookinfo,HttpServletResponse response) throws IOException {
		String uploadPath = servletContext.getRealPath("/resources/img");
	  
	      System.out.println(cookinfo);
	   
	      ModelAndView mav = new ModelAndView();
	      MultipartFile multi = cookinfo.getUpload();
	      
	      int cnt = -1;
	      cnt = cdao.insertCookInfo(cookinfo);
	      
	      if(cnt != -1) {
	         
	         mav.setViewName(gotoPage+"?infokind="+cookinfo.getInfokind());
	         
	         File destination = new File(uploadPath + File.separator + multi.getOriginalFilename());
	        
	         
	         try {
	            
	            multi.transferTo(destination);
	          
	            
	         }catch (IllegalStateException e) {
	            e.printStackTrace();
	         }catch (IOException e) {
	            e.printStackTrace();
	         }
	         
	      }else {
	         
	         mav.setViewName(getPage);
	      
	      }
	      
	   
	      return mav;

	}

	   @Override
	   public void setServletContext(ServletContext context) {
	      // TODO Auto-generated method stub
	      
	      servletContext = context;
	   }
	   
}