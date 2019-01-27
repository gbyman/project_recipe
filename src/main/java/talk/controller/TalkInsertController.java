package talk.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import allmember.model.AllMember;
import talk.model.Talk;
import talk.model.TalkDao;

@Controller
@RequestMapping("/talk")
public class TalkInsertController {
	private static final String command="/insert.bod";
	private static final String getPage="TalkInsertForm";
	private static final String gotoPage="redirect:/talk/list.bod";
	
	@Autowired
	private TalkDao talkDao;
	
	@Autowired
	ServletContext servletcontext;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	private String goInsertForm() {
		return getPage;
	}
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	private String goInsert(Talk talk,HttpSession session,HttpServletResponse response) {
		System.out.println(talk);
		AllMember member=new AllMember();
		member=(AllMember)session.getAttribute("loginInfo");
		
		if(member==null) {
			return "redirect:/login.mem";
		}
		
		talk.setTid(member.getId());
		if(talk.getTmovie().length()>0) {
			talk.setTmovie(talk.getTmovie().substring(17, 28));
		}
			
		String uploadPath=servletcontext.getRealPath("/resources/img");
		System.out.println(uploadPath);
		MultipartFile multi=talk.gettUploader();
		
		int cnt=talkDao.TalkInsert(talk);
		
		if(cnt>0) {
			if(multi.getSize()>0) {
				File file=new File(uploadPath+File.separator+multi.getOriginalFilename());
				
				try {
					multi.transferTo(file);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return gotoPage;
		
		}else {
			try {
			PrintWriter writer;
			response.setContentType("text/html;charset=UTF-8");
			writer=response.getWriter();
			writer.println("<script type='text/javascript'>");
			writer.println("alert('등록을 실패했습니다.')");
			writer.println("history.back()");
			writer.println("</script>");
			writer.flush();
			writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return getPage;
		}
		
		
	}
}
