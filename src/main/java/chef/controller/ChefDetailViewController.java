package chef.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import chef.model.Chef;
import chef.model.ChefDao;

@Controller
public class ChefDetailViewController {//ChefList.jsp에서 넘어옴
	
	private static final String command = "/detail.cf";
	private static final String getPage = "ChefDetailView";
	
	@Autowired 
	private ChefDao chefDao;
	
	//chefnum을 통해 데이터 가지고 와서 ChefDetailView.jsp로 이동 
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doActionGet(@RequestParam(value="chefnum", required = true)int chefnum, Model model) {
		
		System.out.println("ChefDetailView num : " + chefnum);
		System.out.println("ChefDatailView Get방식");
		
		Chef chef = chefDao.GetData(chefnum);
		model.addAttribute("chef", chef);
		
		return getPage;//ChefDetailView.jsp로 이동
	}

}
