package allmember.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import allmember.model.AllMember;
import allmember.model.AllMemberDao;
import allmember.model.Email;
import allmember.model.EmailSender;

@Controller
public class FindPwController {
	private static final String command="/findpw.mem";
	private static final String getPage="FindPw";
	private static final String gotoPage="redirect:/login.mem";
	
	@Autowired 
	private AllMemberDao adao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String goFindPwForm() {
		return getPage;
	}
	
	@Autowired
	   private EmailSender emailSender;
	   @Autowired
	   private Email email;
	    @RequestMapping(value=command,method=RequestMethod.POST)
	    public String sendEmailAction (AllMember member, HttpServletResponse response) throws Exception {
	        
	        AllMember bean=adao.FindPw(member);
	        PrintWriter writer;
	        System.out.println(bean);
			response.setContentType("text/html;charset=UTF-8");
			writer=response.getWriter();
	        if(bean!=null) {
	            email.setContent("비밀번호는 "+bean.getPassword()+" 입니다.");
	            email.setReceiver(bean.getEmail1()+"@"+bean.getEmail2());
	            email.setSubject(bean.getId()+"님 비밀번호 찾기 메일입니다.");
	            emailSender.SendEmail(email);
	            
	            writer.println("<script type='text/javascript'>");
				writer.println("alert('회원님의 패스워드를 가입된 email주소로 전송했습니다.')");
				writer.println("location.href='login.mem'");
				writer.println("</script>");
				writer.flush();
				writer.close();
	            return gotoPage;
	        }else {
	        	writer.println("<script type='text/javascript'>");
				writer.println("alert('회원정보가 맞지않습니다.')");
				writer.println("history.back()");
				writer.println("</script>");
				writer.flush();
				writer.close();
				return getPage;
	        }
	    }
	
}