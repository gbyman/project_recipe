package reply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import reply.model.Reply;
import reply.model.ReplyDao;

@Controller
@RequestMapping("/reply")
public class ReplyUpdateController {
	private static final String command="/reUpdate.bod";
	
	@Autowired
	private ReplyDao replyDao;
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	@ResponseBody
	public int goReplyUpdate(Reply reply) {
		System.out.println(reply);
		return replyDao.reUpdate(reply);
	}
	
}
