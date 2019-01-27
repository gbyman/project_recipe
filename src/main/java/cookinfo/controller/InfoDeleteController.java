package cookinfo.controller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;

import cookinfo.model.CookInfo;
import cookinfo.model.CookInfoDao;

@Controller
public class InfoDeleteController implements ServletContextAware{
	
	private static final String gotoPage = "redirect:/infolist.bod";
	private static final String command = "/infodelete.bod";
	
	private ServletContext servletContext;
	
	@Autowired
	@Qualifier("MyCookInfoDao")
	private CookInfoDao cdao;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doActionGet(
				@RequestParam(value="infokind",required=false) String infokind,
				@RequestParam("pageNumber") int pageNumber,
				@RequestParam(value="infonum",required=true) int infonum){
		
		System.out.println("Get ¹æ½Ä µé¾î¿È");
		int cnt = -1;
		
		CookInfo cookinfo=cdao.GetCook(infonum);
		
		String uploadDir = servletContext.getRealPath("/resources/"); 
		File delFile = new File( uploadDir + File.separator +cookinfo.getInfoimage() );
		cnt = cdao.DeleteData( infonum );
		delFile.delete();
		
		if(cnt>0) {
			int totalCount=cdao.totalimageCount();
			int pageCount=totalCount/5+(totalCount%5==0?0:1);
			if(pageCount<pageNumber) { pageNumber--;}
		}
		
		
		return gotoPage+"?infokind="+cookinfo.getInfokind()+"&pageNumber="+pageNumber;
	}

	
	@Override
	public void setServletContext(ServletContext context) {
		// TODO Auto-generated method stub
		servletContext=context;
	}

}
