package opinion.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import allmember.model.AllMember;
import opinion.model.Opinion;
import opinion.model.OpinionDao;

@Controller
@RequestMapping("/opinion")
public class OpinionDetailController {
	private static final String command="/detail.bod";
	private static final String getPage="OpinionDetail";
	
	@Autowired
	private OpinionDao oDao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	private String goDetail(
			@RequestParam(value="pageNumber",required=false) String pageNumber,
			@RequestParam(value="opnum",required=false)int opnum,
			Model model,
			HttpSession session
			) {
		
		AllMember member=new AllMember();
		member=(AllMember)session.getAttribute("loginInfo");
		
		if(member==null) {
			return "redirect:/login.mem";
		}
		Opinion opinion=oDao.selectByOpnum(opnum);
		System.out.println(opinion);

		model.addAttribute("bean", opinion);
		model.addAttribute("pageNumber", pageNumber);
		return getPage;
	}
}
