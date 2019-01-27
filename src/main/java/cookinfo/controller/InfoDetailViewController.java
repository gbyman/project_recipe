package cookinfo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import cookinfo.model.CookInfo;
import cookinfo.model.CookInfoDao;

@Controller
public class InfoDetailViewController {
	private static final String command = "/infodetail.bod";	
	private static final String getPage = "InfoDetailView";	
	private static final String getPage2 = "InfoDetailView2";	
	@Autowired
	@Qualifier("MyCookInfoDao")
	private CookInfoDao cdao;
	
	@RequestMapping(value=command, method=RequestMethod.GET)	//앨범리스트.jsp에서 
	public String doActionGet(
			@RequestParam(value="infokind",required=false) String infokind,
			@RequestParam(value="infonum",required=true) int infonum,		// num 꼭필요함
			@RequestParam(value = "pageNumber", required = false ) String pageNumber,
			Model model) {
		
		System.out.println("GET방식 들어옴");
		System.out.println("pageNumber : " + pageNumber + ", ");
		
		
		CookInfo cookinfo=cdao.GetCook(infonum);	//select 
		
		model.addAttribute("cookinfo",cookinfo);
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("infokind", infokind);
		
		if(infokind.equals("image")) {
			return getPage;
		}else {
			return getPage2;
		}
		
	}
}



