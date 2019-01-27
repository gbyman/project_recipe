package allmember.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import allmember.model.AllMember;
import allmember.model.AllMemberDao;

@Controller
public class LoginController {
	private static final String command="/login.mem";
	private static final String	getPage="login";
	
	@Autowired
	@Qualifier("MyAllMemberDao")
	private AllMemberDao adao;
	
	@RequestMapping(value=command , method=RequestMethod.GET)  
	public String goLogin(
			@RequestParam(value="id",required=false) String id,
			@RequestParam(value="password",required=false) String password,
			Model model) {
		model.addAttribute("userid", id);
		model.addAttribute("userpw", password);
		return getPage;
	}
	@RequestMapping(value=command,method=RequestMethod.POST )
	public void gotoLogin(
			@RequestParam("id") String id,
			@RequestParam("password") String password,
			HttpServletResponse response,
			HttpSession session
			) throws IOException {
		Map<String, String>map=new HashMap<String, String>();
		
		map.put("id", id);
		map.put("password", password);
		
		
		AllMember member=adao.LoginSelect(map);
		PrintWriter writer;
		response.setContentType("text/html;charset=UTF-8");
		writer=response.getWriter();
		
		if(member==null) {
			writer.println("<script type='text/javascript'>");
			writer.println("alert('등록된 아이디가 없습니다.')");
			writer.println("history.back()");
			writer.println("</script>");
			writer.flush();
			writer.close();
		}else {
			if(member.getId().equals(id) && member.getPassword().equals(password)) {
				session.setAttribute("loginInfo",member);
				writer.println("<script type='text/javascript'>");
				writer.println("alert('"+id+"님 어서오세요.')");
				writer.println("location.href='mainPage.rec'");
				writer.println("</script>");
				writer.flush();
				writer.close();
				
				
			}else {
				writer.println("<script type='text/javascript'>");
				writer.println("alert('비밀번호를 다시 확인해주세요.')");
				writer.println("history.back()");
				writer.println("</script>");
				writer.flush();
				writer.close();
				
			}
		}
		
	}
}
