package allmember.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import allmember.model.AllMember;
import allmember.model.AllMemberDao;

@Controller
@RequestMapping("/update")
public class MemberUpdateController {
	private static final String command1="/info.mem";
	private static final String command2="/passwd.mem";
	private static final String getPage1="MemberUpdateForm";
	private static final String getPage2="MemberPasswdUpdate";
	private static final String gotoPage="redirect:/mainPage.rec";
	
	@Autowired
	private AllMemberDao aDao;
	
	@Autowired
	ServletContext context;
	
	@RequestMapping(value=command1,method=RequestMethod.GET)
	private String goUpdateForm(HttpSession session,Model model) {
		AllMember member=(AllMember)session.getAttribute("loginInfo");
		
		if(member==null) {
			return "redirect:/login.mem";
		}
		Map<String, String>map=new HashMap<>();
		map.put("id", member.getId());
		AllMember bean=aDao.LoginSelect(map);
		model.addAttribute("bean", bean);
		return getPage1;
	}
	@RequestMapping(value=command1,method=RequestMethod.POST)
	private void goUpdate(AllMember allmember,HttpSession session,HttpServletResponse response,
			HttpServletRequest request
			) throws IllegalStateException, IOException {
		PrintWriter writer;
		response.setContentType("text/html;charset=UTF-8");
		writer=response.getWriter();
		String contextPath=request.getContextPath();
		AllMember member=(AllMember)session.getAttribute("loginInfo");
		if(member==null) {
			writer.println("<script type='text/javascript'>");
			writer.println("alert('로그인을 해야합니다.')");
			writer.println("location.href='"+contextPath+"/login.mem'");
			writer.println("</script>");
			writer.flush();
			writer.close();
		}
		MultipartFile multi=allmember.getImgUpload();
		System.out.println(allmember);
		if(multi.getSize()==0) {
			allmember.setImg(allmember.getImg2());
		}
		if(allmember.getEmail2().equals("insert")) {
			allmember.setEmail2(allmember.getEmail3());
		}
		int cnt=aDao.updateMemberInfo(allmember);
		String uploadir=context.getRealPath("/resources/img/"+allmember.getId()+"Profile");
		File profileFolder=new File(uploadir);
		if(!profileFolder.exists()) {
			profileFolder.mkdirs();
		}
		
		
		if(cnt>0) {
			if(multi.getSize()!=0) {
				File del=new File(uploadir+File.separator+allmember.getImg2());
				del.delete();
				
				File file=new File(uploadir+File.separator+multi.getOriginalFilename());
				multi.transferTo(file);
			}
			writer.println("<script type='text/javascript'>");
			writer.println("alert('수정에 성공했습니다.')");
			writer.println("location.href='"+contextPath+"/mainPage.rec'");
			writer.println("</script>");
			writer.flush();
			writer.close();
		}else {
			writer.println("<script type='text/javascript'>");
			writer.println("alert('수정에 실패했습니다.')");
			writer.println("history.back()");
			writer.println("</script>");
			writer.flush();
			writer.close();
		}
		
	}
	
	@RequestMapping(value=command2,method=RequestMethod.GET)
	private String goUpdatePasswdForm(HttpSession session) {
		AllMember member=(AllMember)session.getAttribute("loginInfo");
		
		if(member==null) {
			return "redirect:/login.mem";
		}
		
		return getPage2;
	}
	@RequestMapping(value=command2,method=RequestMethod.POST)
	private void goUpdatePasswd(
			@RequestParam("password") String password,
			HttpSession session,
			HttpServletResponse response,HttpServletRequest request) throws IOException {
		PrintWriter writer;
		response.setContentType("text/html;charset=UTF-8");
		writer=response.getWriter();
		String contextPath=request.getContextPath();
		AllMember member=(AllMember)session.getAttribute("loginInfo");
		
		if(member==null) {
			writer.println("<script type='text/javascript'>");
			writer.println("alert('로그인을 해야합니다.')");
			writer.println("location.href='"+contextPath+"/login.mem'");
			writer.println("</script>");
			writer.flush();
			writer.close();
		}
		Map<String, String>map=new HashMap<>();
		map.put("id", member.getId());
		map.put("password", password);
		
		int cnt=aDao.updateMemberPasswd(map);
		
		if(cnt>0) {
			writer.println("<script type='text/javascript'>");
			writer.println("alert('수정에 성공했습니다.')");
			writer.println("location.href='"+contextPath+"/mainPage.rec'");
			writer.println("</script>");
			writer.flush();
			writer.close();
		}else {
			writer.println("<script type='text/javascript'>");
			writer.println("alert('수정에 실패했습니다.')");
			writer.println("history.back()");
			writer.println("</script>");
			writer.flush();
			writer.close();
		}
		
	}
	
	
}
