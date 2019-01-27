package talk.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import talk.model.Talk;
import talk.model.TalkDao;

@Controller
@RequestMapping("/talk")
public class TalkUpdateController {
	private static final String command="/update.bod";
	private static final String getPage="TalkUpdateForm";
	private static final String gotoPage="redirect:/talk/list.bod";
	
	@Autowired
	private TalkDao talkDao;
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	private String goUpdateForm(@RequestParam("tnum") int tnum,Model model) {
		
		Talk bean=talkDao.selectByTnum(tnum);
		if(bean.getTmovie()!=null) {
			bean.setTmovie("https://youtu.be/"+bean.getTmovie());
		}
		
		model.addAttribute("bean", bean);
		return getPage;
	}
	@RequestMapping(value=command,method=RequestMethod.POST)
	private String goUpdate(Talk talk,HttpServletResponse response,HttpSession session) throws IllegalStateException, IOException {
		if(session.getAttribute("loginInfo")==null) {
			return "redirect:/login.mem";
		}
		System.out.println(talk);
		String uploadPath=servletContext.getRealPath("/resources/img");
		if(!talk.getTmovie().trim().equals("")) {
			talk.setTmovie(talk.getTmovie().substring(17, 28));
		}
		MultipartFile multi=talk.gettUploader();
		if(multi.getSize()==0) {
			talk.setTimage(talk.gettUploader2());
		}
		int cnt=talkDao.updateTalk(talk);
		if(cnt>0) {
			if(multi.getSize()!=0) {
				int count=talkDao.getCountByImage(talk.gettUploader2());
				if(count<=1) {
					File del=new File(uploadPath+File.separator+talk.gettUploader2());
					del.delete();	
				}
				File file=new File(uploadPath+File.separator+multi.getOriginalFilename());
				multi.transferTo(file);
			}
		}else {
			try {
				PrintWriter writer;
				response.setContentType("text/html;charset=UTF-8");
				writer=response.getWriter();
				writer.println("<script type='text/javascript'>");
				writer.println("alert('수정에 실패했습니다.')");
				writer.println("history.back()");
				writer.println("</script>");
				writer.flush();
				writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			return getPage;
		}
		
		return gotoPage;
	}
}
