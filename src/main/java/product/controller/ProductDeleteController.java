package product.controller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import product.model.Product;
import product.model.ProductDao;

@Controller
public class ProductDeleteController {
	
	private static final String command = "/delete.mt";
	private static final String gotoPage = "redirect:/list.mt";
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private ProductDao productDao;
	
	//pnum을 통한 데이터 지우기
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doActionGet(@RequestParam(value="pnum", required = true)int pnum) {
		
		System.out.println("ProductDeleteController num : " + pnum);
		System.out.println("ProductDeleteController Get방식");
		
		Product product = productDao.GetData(pnum);
		
		//폴더에 저장된 이미지 삭제 준비
		String uploadDir = servletContext.getRealPath("/resources/mart/");
		File delUploadpimage = new File(uploadDir + File.separator + product.getPimage());
		
		int cnt = -1;
		cnt = productDao.DeleteData(pnum);
		
		delUploadpimage.delete();
		//이미지 삭제
		return gotoPage; //redirect:/list.mt
	}

}
