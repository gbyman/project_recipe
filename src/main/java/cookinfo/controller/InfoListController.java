package cookinfo.controller;



import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;


import cookinfo.model.CookInfo;
import cookinfo.model.CookInfoDao;

import utility.infoPaging;

@Controller
public class InfoListController {
	private static final String command="/infolist.bod";
	private static final String	getPage="Infolist";
	private static final String	getPage2="Infolist2";
	@Autowired
	@Qualifier("MyCookInfoDao")
	private CookInfoDao cdao;
	
	@RequestMapping(value=command)
	public String goListFormgoList(
			CookInfo cookinfo,
			@RequestParam(value="infokind",required=false) String infokind,
			@RequestParam(value="pageNumber", required=false) String pageNumber,
			@RequestParam(value="pageSize", required=false) String pageSize,
	
			HttpServletRequest request,
			Model model
			) {

		if(infokind==null) {
			infokind="image";
		}
		int totalinfokindCount=cdao.totalinfokindCount(infokind);
	

	String url=request.getContextPath()+command;
	
	infoPaging pageInfo=new infoPaging(pageNumber, pageSize, totalinfokindCount, url, infokind);
	
	List<CookInfo> list=cdao.selectPageRow(pageInfo,infokind);
	
	model.addAttribute("pageInfo", pageInfo);
	model.addAttribute("list", list);
	model.addAttribute("infokind", infokind);
		
	if(infokind.equals("image")) {
		return getPage;
	}else {
		return getPage2;
	}
	}
	
	
}