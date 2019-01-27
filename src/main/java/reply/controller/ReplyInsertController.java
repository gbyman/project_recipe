package reply.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import reply.model.Reply;
import reply.model.ReplyDao;

@Controller
@RequestMapping("/reply")
public class ReplyInsertController {
	private static final String command="/insert.bod";
	
	@Autowired
	@Qualifier("MyReplyDao")
	private ReplyDao replyDao;
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	@ResponseBody
	public int replyInsert(Reply reply, HttpServletResponse response) {
		System.out.println(reply);
		
		return replyDao.InsertReply(reply);
	}
}
