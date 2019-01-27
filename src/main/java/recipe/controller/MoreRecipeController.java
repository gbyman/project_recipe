package recipe.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import recipe.model.Recipe;
import recipe.model.RecipeDao;

@Controller
public class MoreRecipeController {
	private static final String command="/moreRecipe.rec";
	
	@Autowired
	private RecipeDao recDao;
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	@ResponseBody
	public void moreRecipe(@RequestParam("count") int count,HttpServletResponse response) {
		System.out.println(count);
		int offset=(count-1)*3;
		List<Recipe> list=recDao.recentRecipe(offset);
		
		String str="";
		
		
		try {
			PrintWriter writer;
			response.setContentType("text/html;charset=UTF-8");
			writer=response.getWriter();
			ObjectMapper mapper=new ObjectMapper();
			str=mapper.writeValueAsString(list);
			System.out.println(str);
			writer.println(str);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} 
}
