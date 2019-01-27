package opinion.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import opinion.model.Opinion;
import opinion.model.OpinionDao;
import utility.OpPaging;

@Controller
@RequestMapping("/opinion")
public class OpinionListController {
	private static final String command="/list.bod";
	private static final String getPage="OpinionList";
	
	@Autowired
	private OpinionDao oDao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	private String goList(
			@RequestParam(value="cate",required=false)String cate,
			@RequestParam(value="pageNumber",required=false) String pageNumber,
			@RequestParam(value="pageSize",required=false) String pageSize,
			Model model,HttpServletRequest request
			) {
		if(cate==null) {
			cate="question";
		}
		if(cate.equals("oplist")) {
			int totalCount=oDao.getTotalCount();
			System.out.println(totalCount);
			String url=request.getContextPath()+"/opinion"+command;
			
			OpPaging pageInfo=new OpPaging(pageNumber, pageSize, totalCount, url, cate);
			
			List<Opinion>list=oDao.selectAllOpinion(pageInfo);
			
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("list", list);
		}
		model.addAttribute("cate", cate);
		return getPage;
	}
	
}
