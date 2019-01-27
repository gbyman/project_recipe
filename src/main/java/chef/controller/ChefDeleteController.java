package chef.controller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import chef.model.Chef;
import chef.model.ChefDao;

@Controller
public class ChefDeleteController {
	
	private static final String command = "/delete.cf";
	private static final String gotoPage = "redirect:/list.cf";
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private ChefDao chefDao;
	
	//chefnum을 통해서 데이터 지우기
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doActionGet(@RequestParam(value="chefnum", required=true)int chefnum) {
		
		System.out.println("ChefDeleteController num : " + chefnum);
		System.out.println("ChefDeleteController GET 방식");
		
		Chef chef = chefDao.GetData(chefnum);
		
		//데이터 등록할 때 저장한 이미지 삭제하도록 해야함
		String uploadDir = servletContext.getRealPath("/resources/chef/");
		
		//DEV : 일단은 파일 하나 하나 지우는 하드 코딩 : 하나로 묶어서 지울 수 있도록 해야함
		
		File delCmainImageFile = new File(uploadDir + File.separator + chef.getCmainimage());
		File delCimg1File = new File(uploadDir + File.separator + chef.getCimage1());
		File delCimg2File = new File(uploadDir + File.separator + chef.getCimage2());
		File delCimg3File = new File(uploadDir + File.separator + chef.getCimage3());
		File delCimg4File = new File(uploadDir + File.separator + chef.getCimage4());
		
		int cnt = -1;
		cnt = chefDao.DeleteData(chefnum);
		
		delCmainImageFile.delete();
		delCimg1File.delete();
		delCimg2File.delete();
		delCimg3File.delete();
		delCimg4File.delete();
		
		return gotoPage; //redirect:/list.cf
	}
}
