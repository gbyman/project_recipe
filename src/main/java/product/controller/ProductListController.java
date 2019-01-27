package product.controller;


import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import product.model.Product;
import product.model.ProductDao;
import utility.productPaging;


@Controller
public class ProductListController {
	
	private static final String getPage = "ProductList";
	private static final String command = "/list.mt";
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping(value = command)
	public String doActionPost(
			Product product,
			@RequestParam(value="pkind",required=false) String pkind,
			@RequestParam(value="pageNumber", required=false) String pageNumber,
			@RequestParam(value="pageSize", required=false) String pageSize,
	
			HttpServletRequest request,
			Model model
			) {
		if(pkind==null) {
			pkind="pkind1";
		}
		
		int totalpkindCount=productDao.totalpkindCount(pkind);
		
		
		String url=request.getContextPath()+command;
		  
		productPaging pageInfo=new productPaging(pageNumber, pageSize, totalpkindCount, url, pkind);
		
		List<Product> list=productDao.selectPageRow(pageInfo,pkind);
		
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("list", list);
		model.addAttribute("pkind", pkind);	
		
		
		return getPage;
	
	
		
		
	}
	
	
}