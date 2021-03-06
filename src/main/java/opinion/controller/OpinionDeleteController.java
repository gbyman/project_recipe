package opinion.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import allmember.model.AllMember;
import opinion.model.OpinionDao;

@Controller
@RequestMapping("/opinion")
public class OpinionDeleteController {
	private static final String command="/delete.bod";
	private static final String getPage="redirect:/opinion/list.bod?cate=oplist";
	
	@Autowired
	private OpinionDao oDao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	private void godelete(
			@RequestParam("opnum")int opnum,
			@RequestParam("pageNumber")String pageNumber,
			HttpServletResponse response,
			HttpSession session,
			HttpServletRequest request
			) throws IOException {
		PrintWriter writer=null;
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
		int cnt=oDao.deleteOpinion(opnum);
		
		
		if(cnt>0) {
			writer.println("<script type='text/javascript'>");
			writer.println("alert('삭제되었습니다.')");
			writer.println("location.href='"+contextPath+"/opinion/list.bod?cate=oplist&pageNumber="+pageNumber+"'");
			writer.println("</script>");
			writer.flush();
			writer.close();
		}else {
			writer.println("<script type='text/javascript'>");
			writer.println("alert('삭제에 실패했습니다.')");
			writer.println("history.back()");
			writer.println("</script>");
			writer.flush();
			writer.close();
		}
		
	}
}
