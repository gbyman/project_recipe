package reply.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import allmember.model.AllMember;
import reply.model.Reply;
import reply.model.ReplyDao;

@Controller
@RequestMapping("/reply")
public class ReplyListController {
	private static final String command="/list.bod";
	
	@Autowired
	private ReplyDao replyDao;
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	private void getReplyList(Reply reply, HttpServletResponse response,HttpSession session) {
		
		List<Reply> list=replyDao.selectAllReply(reply,0);
		String str="";
		
		AllMember member=new AllMember();
		member=(AllMember)session.getAttribute("loginInfo");
		
		try {
			PrintWriter writer;
			response.setContentType("text/html;charset=UTF-8");
			writer=response.getWriter();
		
			for(Reply a:list) {
				
				str+="<div>";
				if(a.getRelevel()>0) {
					int wid=a.getRelevel()*50;
					str+="<img src='/ex/resources/img/level.gif' width='"+wid+"' height='16'>";
					str+="<img src='/ex/resources/img/re.gif'>";
				}else {
					str+="<img src='/ex/resources/img/level.gif' width='0' height='16'>";
				}
				str+="<img src='/ex/resources/img/"+a.getRewriter()+"Profile/"+a.getReimg()+"' width='50' height='50'>";
	        	str+=a.getRenickname()+" &nbsp "+a.getDateString();
	        	
	        	if(member!=null){
	        		str+="|<a onclick='replyReply("+a.getRenum()+","+a.getRef()+","+a.getRelevel()+","+a.getRestep()+")'>답글</a>";
	        	};
	        	
	        	if(member!=null && member.getId().equals(a.getRewriter())) {
	        		str+="|<a onclick='replyUpdate("+a.getRenum()+",\""+a.getContent()+"\")'>수정</a>|<a onclick='replyDelete("+a.getRenum()+")'>삭제</a>";
	        	};
	        	
	        	str+="<br><div class='replyUpdate"+a.getRenum()+"'><p>"+a.getContent()+"</p></div><div class='replyContent"+a.getRenum()+"'></div></div>";
		
			}
        	writer.println(str);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
