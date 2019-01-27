package recipe.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import recipe.model.Recipe;
import recipe.model.RecipeDao;

@Controller
public class MainHomeController {
	private static final String command="/mainPage.rec";
	private static final String	getPage="MainHome";
	 
	@Autowired
	private RecipeDao recipeDao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public ModelAndView goMainHome(
			HttpSession session) {
		
		ModelAndView mav=new ModelAndView();
		
		List<Recipe> list = recipeDao.recentRecipe(0);
		mav.addObject("list", list);
		
		mav.setViewName(getPage);
		
		return mav;
	}
}
