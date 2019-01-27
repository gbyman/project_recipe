package recipe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import recipe.model.Recipe;
import recipe.model.RecipeDao;
import utility.Paging;
import utility.recipePaging;

@Controller
public class RecipeListController {
	
	private static final String getPage = "RecipeList";
	private static final String command = "/list.rec";
	
	@Autowired
	private RecipeDao recipeDao;
	
	//홈페이지에서 레시피 버튼 클릭시 이동kewyword )
	@RequestMapping(value = command)
	public String doActionPost(
			@RequestParam(value="theme",required=false)String theme,
			@RequestParam(value="keyword",required=false)String keyword,
			@RequestParam(value="what",required=false)String what,
			@RequestParam(value="pageNumber", required = false)String pageNumber,
			@RequestParam(value="pageSize", required = false)String pageSize,
			HttpServletRequest request,
			Model model) {
		
		if(theme==null) {
			theme="all";
		}
		if(what==null) {
			what="no";
		}
		System.out.println("theme:"+theme+","+"keyword:"+keyword);
		Map<String, String>map=new HashMap<>();
		map.put("keyword", "%"+keyword+"%");
		map.put("what", what);
		map.put("theme", theme);
		
		System.out.println(map.get(keyword));
		int totalCount =recipeDao.GetTotalCount(map);

		String url = request.getContextPath() +command;
		
	
		recipePaging pageInfo = new recipePaging(pageNumber, pageSize, totalCount, url, theme, keyword,what);
		
		List<Recipe> recipeLists = recipeDao.GetDataList(pageInfo, map);
		
		System.out.println("recipeLists.size() : " + recipeLists.size());
		
		model.addAttribute("recipeLists", recipeLists);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("theme",theme);
		
		return getPage;//페이지 정보와 레시피 정보 담아서 RecipeList.jsp로 이동
		
	}//

}
