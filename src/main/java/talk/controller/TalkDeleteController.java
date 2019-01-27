package talk.controller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import reply.model.Reply;
import reply.model.ReplyDao;
import talk.model.Talk;
import talk.model.TalkDao;

@Controller
@RequestMapping("/talk")
public class TalkDeleteController {
	private static final String command="/delete.bod";
	private static final String gotoPage="redirect:/talk/list.bod";
	
	@Autowired
	private TalkDao talkDao;
	
	@Autowired
	ReplyDao replyDao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	private String goDelete(@RequestParam("tnum") int tnum) {
		Talk talk=talkDao.selectByTnum(tnum);
		
		
		Reply bean=new Reply();
		
		bean.setCanum(tnum);
		bean.setCate("talk");
		
		System.out.println(bean);
		
		int redelCnt=replyDao.deleteAllByTnum(bean);
		System.out.println("replyDeleteCnt:"+redelCnt);
		
		int cnt=talkDao.deleteTalk(tnum);
		if(cnt>0) {
			String uploadDir=servletContext.getRealPath("/resources/img");
			
			File image=new File(uploadDir+File.separator+talk.getTimage());
			image.delete();
			
			
		}
		
		return gotoPage;
	}
}
