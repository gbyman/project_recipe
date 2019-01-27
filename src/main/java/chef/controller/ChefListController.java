package chef.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import chef.model.Chef;
import chef.model.ChefDao;
import utility.chefPaging;

@Controller
public class ChefListController {
	
	private static final String getPage = "ChefList";
	private static final String command = "/list.cf";
	
	@Autowired
	private ChefDao chefDao;
	
	//홈페이지 메뉴에서 내가 셰프 버튼 클릭시 이동, 셰프 변수는 레시피 변수와 동일
	@RequestMapping(value = command)
	public String doActionPost(
			@RequestParam(value="pageNumber", required=false) String pageNumber,
			@RequestParam(value="pageSize", required=false) String pageSize,
			HttpServletRequest request,Model model) {
		
		
		int totalCount = chefDao.GetTotalCount();
		
	
		String url = request.getContextPath() +command;
		 
	
		
		chefPaging pageInfo = new chefPaging(pageNumber, pageSize, totalCount, url, null, null, null);
		//keyword를 null값으로 설정
		System.out.println("pageInfo"+pageInfo.getOffset()+","+pageInfo.getLimit());
		
		List<Chef> chefLists = chefDao.GetDataList(pageInfo);
		
		System.out.println("chefLists.size() : " + chefLists.size());
		
		model.addAttribute("chefLists", chefLists);
		model.addAttribute("pageInfo", pageInfo);
		
		
		return getPage;//페이지 정보와 ChefList 정보 담아서 ChefList.jsp로 이동
	}

}
