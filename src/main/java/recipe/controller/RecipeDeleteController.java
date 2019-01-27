package recipe.controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import procedure.model.Procedure;
import procedure.model.ProcedureDao;
import recipe.model.Recipe;
import recipe.model.RecipeDao;

@Controller
public class RecipeDeleteController {
	
	private static final String command = "/delete.rec";
	private static final String gotoPage = "redirect:/list.rec";
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private RecipeDao recipeDao;
	
	
	
	//recnum를 통해서 데이터 지우기
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doActionGet(@RequestParam(value="recnum", required = true) int recnum) {
		
		
		System.out.println("RecipeDeleteController num : " + recnum);
		System.out.println("RecipeDeleteController Get방식");
		
		Recipe recipe = recipeDao.GetData(recnum);
		
		//레시피 등록할 때 이미지가 저장된 폴더, 폴더 내에 저장된 이미지도 삭제되도록 해야함
		String uploadDir = servletContext.getRealPath("/resources/recipe/"+recipe.getWriter()+"Recipe");
		
		//DEV : 일단은 파일 하나 하나 지우는 하드 코딩 : 하나로 묶어서 지울 수 있도록 해야함
		
		File delMainImageFile = new File(uploadDir + File.separator + recipe.getMainimage());
		File delImg1File = new File(uploadDir + File.separator + recipe.getImage1());
		File delImg2File = new File(uploadDir + File.separator + recipe.getImage2());
		File delImg3File = new File(uploadDir + File.separator + recipe.getImage3());
		File delImg4File = new File(uploadDir + File.separator + recipe.getImage4());
		
		int cnt = -1;
		cnt = recipeDao.DeleteData(recnum);
		if(cnt>0) {
			delMainImageFile.delete();
			delImg1File.delete();
			delImg2File.delete();
			delImg3File.delete();
			delImg4File.delete();
			
		}
		return gotoPage; //redirect:/list.rec
	}

}
