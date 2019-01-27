package allmember.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import allmember.model.AllMember;
import allmember.model.AllMemberDao;
import opinion.model.OpinionDao;
import recipe.model.RecipeDao;
import reply.model.ReplyDao;
import talk.model.TalkDao;

@Controller
public class MemberDeleteController {
	private static final String command="/delete.mem";
	
	@Autowired
	private AllMemberDao aDao;
	
	@Autowired
	private ReplyDao replyDao;
	
	@Autowired
	private RecipeDao recipeDao;
	
	@Autowired
	private OpinionDao oDao;
	
	@Autowired
	private TalkDao tDao;
	
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	private void goDeleteMember(HttpSession session,HttpServletResponse response,HttpServletRequest request) throws IOException {
		PrintWriter writer;
		response.setContentType("text/html;charset=UTF-8");
		writer=response.getWriter();
		
		String contextPath=request.getContextPath();
		
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
		int cnt=aDao.deleteMember(member.getId());
		
		if(cnt>0) {
			recipeDao.deleteById(member.getId());
			replyDao.deleteById(member.getId());
			oDao.deleteById(member.getId());
			tDao.deleteById(member.getId());
			session.invalidate();
			
			writer.println("<script type='text/javascript'>");
			writer.println("alert('회원탈퇴 되셨습니다.')");
			writer.println("location.href='"+contextPath+"/mainPage.rec'");
			writer.println("</script>");
			writer.flush();
			writer.close();
		}else {
			writer.println("<script type='text/javascript'>");
			writer.println("alert('회원탈퇴에 실패했습니다.')");
			writer.println("history.back()");
			writer.println("</script>");
			writer.flush();
			writer.close();
		}
		
	}
}
