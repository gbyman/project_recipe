package allmember.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import allmember.model.AllMember;
import allmember.model.AllMemberDao;

@Controller
public class FindIdController {
	private static final String command="/findid.mem";
	private static final String gotoPage="redirect:/login.mem";
	private static final String getPage="FindId";
	
	@Autowired
	private AllMemberDao adao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String goFindidForm() {
		return getPage;
	}
	@RequestMapping(value=command,method=RequestMethod.POST)
	public String goFindid(AllMember member,HttpServletResponse response) throws IOException {
		AllMember bean=adao.Findid(member);
		PrintWriter writer;
		response.setContentType("text/html;charset=UTF-8");
		writer=response.getWriter();
		System.out.println(bean);
		
		if(bean==null) {
			
			writer.println("<script type='text/javascript'>");
			writer.println("alert('아이디가 존재하지않습니다.')");
			writer.println("history.back()");
			writer.println("</script>");
			writer.flush();
			writer.close();
			return getPage;
		}else {
			writer.println("<script type='text/javascript'>");
			writer.println("alert('회원님의 아이디는 "+bean.getId()+"입니다.')");
			writer.println("location.href='login.mem?id="+bean.getId()+"'");
			writer.println("</script>");
			writer.flush();
			writer.close();
			return gotoPage;
		}
		
		
	}
}
