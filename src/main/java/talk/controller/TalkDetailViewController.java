package talk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import talk.model.TalkContainer;
import talk.model.TalkDao;

@Controller
@RequestMapping("/talk")
public class TalkDetailViewController {
	private static final String command="/detailView.bod";
	private static final String getPage="TalkDetailView";
	
	@Autowired
	private TalkDao talkDao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String goDetailViewForm(
			@RequestParam("tnum") int tnum,
			Model model
			) {
		TalkContainer tcontainer=talkDao.containerByTid(tnum);
		
		model.addAttribute("tcontainer", tcontainer);
		return getPage;
	}
}
