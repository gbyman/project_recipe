package opinion.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class OpinionReplyController {
	private static final String command="/reply.bod";
	private static final String getPage="OpinionReplyForm";
	
	@Autowired
	private OpinionDao oDao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	private String goReplyForm(Opinion opinion,
			@RequestParam("pageNumber")String pageNumber,
			Model model
			) {
		System.out.println(pageNumber);
		System.out.println(opinion);
		model.addAttribute("oBean", opinion);
		model.addAttribute("pageNumber", pageNumber);
		
		return getPage;
	}
	@RequestMapping(value=command,method=RequestMethod.POST)
	private void goInsert(
			Opinion opinion,HttpSession session,HttpServletResponse response,HttpServletRequest request
			) throws IOException {
		PrintWriter writer=null;
		response.setContentType("text/html;charset=UTF-8");
		writer=response.getWriter();
		String contextPath=request.getContextPath();
		System.out.println(opinion);
		AllMember member=new AllMember();
		member=(AllMember)session.getAttribute("loginInfo");
		
		if(member==null) {
			writer.println("<script type='text/javascript'>");
			writer.println("alert('로그인을 해야합니다.')");
			writer.println("location.href='"+contextPath+"/login.mem'");
			writer.println("</script>");
			writer.flush();
			writer.close();
		}
		
		opinion.setOpid(member.getId());
		
		int cnt=oDao.replyOpinion(opinion);
		
		if(cnt>0) {
			writer.println("<script type='text/javascript'>");
			writer.println("alert('등록되었습니다.')");
			writer.println("location.href='"+contextPath+"/opinion/list.bod?cate=question'");
			writer.println("</script>");
			writer.flush();
			writer.close();
		}else {
			writer.println("<script type='text/javascript'>");
			writer.println("alert('등록에 실패했습니다.')");
			writer.println("history.back()");
			writer.println("</script>");
			writer.flush();
			writer.close();
		}
		
		
	}
}
