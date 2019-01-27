package allmember.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import allmember.model.AllMember;

@Controller
public class PassController {
	private static final String command="/pass.mem";
	private static final String passPage="Password";
	private static final String goCtr1="redirect:/update/info.mem";
	private static final String goCtr2="redirect:/update/passwd.mem";
	private static final String goCtr3="redirect:/delete.mem";
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	private String goPassForm(
			@RequestParam(value="passnum")int passnum,
			HttpSession session,Model model) {
		AllMember member=(AllMember)session.getAttribute("loginInfo");
		
		if(member==null) {
			return "redirect:/login.mem";
		}
		model.addAttribute("passnum", passnum);
		return passPage;
	}
	@RequestMapping(value=command,method=RequestMethod.POST)
	private String goUpdateController(
			@RequestParam("passnum")int passnum,
			@RequestParam("password")String password,
			HttpSession session,
			HttpServletResponse response
			) throws IOException {
		AllMember member=(AllMember)session.getAttribute("loginInfo");
		
		if(member==null) {
			return "redirect:/login.mem";
		}
		
		if(password.equals(member.getPassword())) {
			if(passnum==1) {
				return goCtr1;
			}else if(passnum==2) {
				return goCtr2;
			}else {
				return goCtr3;
			}
		}else {
			PrintWriter writer;
			response.setContentType("text/html;charset=UTF-8");
			writer=response.getWriter();
			writer.println("<script type='text/javascript'>");
			writer.println("alert('비밀번호가 맞지않습니다.')");
			writer.println("history.back()");
			writer.println("</script>");
			writer.flush();
			writer.close();
			
			return passPage;
		}
		
	}
}
