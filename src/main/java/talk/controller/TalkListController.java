package talk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import talk.model.TalkContainer;
import talk.model.TalkDao;

@Controller
@RequestMapping("/talk")
public class TalkListController {
	private static final String command="/list.bod";
	private static final String getPage="TalkList";
	
	@Autowired
	private TalkDao talkDao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String goTalkList(Model model) {
		List<TalkContainer> list= talkDao.TalkList(0);
		model.addAttribute("list", list);
		return getPage;
	}
}
