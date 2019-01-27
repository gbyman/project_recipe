package reply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import reply.model.ReplyDao;

@Controller
@RequestMapping("/reply")
public class ReplyDeleteController {
	private static final String command="/delete.bod";
	
	@Autowired
	private ReplyDao replyDao;
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	@ResponseBody
	private int goDeleteReply(@RequestParam("renum") int renum) {
		return replyDao.replyDelete(renum);
		
	}
}
