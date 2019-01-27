package talk.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import allmember.model.AllMember;
import reply.model.Reply;
import talk.model.TalkContainer;
import talk.model.TalkDao;

@Controller
@RequestMapping("/talk")
public class InfiniteScrollController {
	private static final String command="infinitescroll.bod";
	
	@Autowired
	private TalkDao talkDao;
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	@ResponseBody
	private void goInfinite(@RequestParam("count") int count , HttpServletResponse response,HttpSession session) {
		System.out.println(count);
		int offset=(count-1)*5;
		List<TalkContainer> list=talkDao.TalkList(offset);
		
		String str="";
		
		AllMember member=new AllMember();
		member=(AllMember)session.getAttribute("loginInfo");
		
		try {
			PrintWriter writer;
			response.setContentType("text/html;charset=UTF-8");
			writer=response.getWriter();
		
			for(TalkContainer a:list) {
				
				str+="<div class='card mb-4'>";
				str+="<div class='card-header'>";
				str+="<a href='/ex/myhome.mem?tid="+a.getTid()+"'>";
				if(!a.getImg().equals("basic.png")) {
					str+="<img alt='프로필사진' src='/ex/resources/img/"+a.getTid()+"Profile/"+a.getImg() +"' width='100' height='100'></a>";
				}else {
					str+="<img alt='프로필사진' src='/ex/resources/img/"+a.getImg() +"' width='100' height='100'></a>";	
				}
				str+=a.getTid();
				if(member!=null) {
					if(member.getId().equals(a.getTid())) {
						str+="<a href='update.bod?tnum="+a.getTnum()+"' class='btn btn-primary'>수정</a>&nbsp";
			          	str+="<a href='delete.bod?tnum="+a.getTnum()+"' class='btn btn-primary'>삭제</a>";
					}
				}
				str+="<br>"+a.getTimeString();
				str+="</div><div class='card-body'>";
				str+="<div class='row'>";
				str+="<div class='col-lg-12'>";
				str+="<a href='detailView.bod?tnum="+a.getTnum()+"'>";
				str+="<p class='card-text'>"+a.getTcontent()+"</p></a></div>";
				str+="<div class='col-lg-12'>";
				str+="<a href='detailView.bod?tnum="+a.getTnum()+"'>";
				if(a.getTimage()!=null) {
					str+="<img class='img-fluid rounded' src='/ex/resources/img/"+a.getTimage()+"' width='300'>";
				}
				str+="</a>";
				if(a.getTmovie()!=null) {
					str+="<iframe width='300' height='200' src='https://www.youtube.com/embed/"+a.getTmovie()+"' frameborder='0' gesture='media' allow='encrypted-media' allowfullscreen></iframe>";
				}
				str+="</div></div></div></div>";
		
			}
        	writer.println(str);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
