package recipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import recipe.model.Recipe;
import recipe.model.RecipeDao;

@Controller
public class RecipeDetailViewController { //RecipeList.jsp 에서 넘어옴
	
	private static final String command = "/detail.rec";
	private static final String getPage = "RecipeDetailView";
	
	@Autowired
	private RecipeDao recipeDao;
	
	//recnum를 통해 데이터 가지고 와서 이동
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doActionGet(@RequestParam(value="recnum", required = true) int recnum, Model model) {
		
		System.out.println("RecipeDetailView num : " + recnum);
		System.out.println("RecipeDetailView Get방식");
		
		Recipe recipe = recipeDao.GetData(recnum); //데이터 가지고 와서 Recipe 형식으로 담는다
		model.addAttribute("recipe", recipe); //Recipe 형식의 recipe를 recipe라는 이름으로 담아 이동준비
		
		return getPage; //RecipeDetailView.jsp로 이동
	}

}
