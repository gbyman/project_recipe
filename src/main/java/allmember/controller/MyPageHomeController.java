package allmember.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import allmember.model.AllMember;
import allmember.model.AllMemberDao;
import opinion.model.Opinion;
import opinion.model.OpinionDao;
import recipe.model.Recipe;
import recipe.model.RecipeDao;
import reply.model.Reply;
import reply.model.ReplyDao;
import talk.model.Talk;
import talk.model.TalkDao;

@Controller
public class MyPageHomeController {
	private static final String command="/myhome.mem";
	private static final String getPage="MyHomePage";
	@Autowired
	private RecipeDao recipeDao;
	
	@Autowired
	private TalkDao talkDao;
	
	@Autowired
	private ReplyDao replyDao;
	
	@Autowired
	private AllMemberDao aDao;
	
	@Autowired
	private OpinionDao opDao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	private String goHomePage(
			@RequestParam(value="tid",required=false)String tid,
			@RequestParam(value="cate",required=false)String cate,
			HttpSession session,Model model) {
		AllMember member=new AllMember();
		member=(AllMember)session.getAttribute("loginInfo");
		System.out.println(cate);
		if(member==null) {
			return "redirect:/login.mem";
		}
		if(cate==null) {
			cate="recipe";
		}
		if(tid==null) {
			tid=member.getId();
		}
		Map<String, String>map=new HashMap<>();
		map.put("id", tid);
		
		AllMember bean=aDao.LoginSelect(map);
		switch (cate) {
		case "recipe":
			List<Recipe>reclist=recipeDao.selectById(tid);
			model.addAttribute("list", reclist);
			break;
		case "talk":
			List<Talk>tlist=talkDao.selectById(tid);
			model.addAttribute("list", tlist);
			break;
		case "reply":
			List<Reply>relist=replyDao.selectById(tid);
			model.addAttribute("list", relist);
			break;
		case "opinion":
			List<Opinion>list=opDao.selectById(tid);
			model.addAttribute("list", list);
			break;
		}
		model.addAttribute("cate", cate);
		model.addAttribute("container", bean);
		return getPage;
		
	}
}
