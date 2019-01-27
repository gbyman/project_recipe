package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import product.model.Product;
import product.model.ProductDao;

@Controller
public class ProductDetailViewController {//ProductList.jsp에서 넘어옴
	
	private static final String command = "/detail.mt";
	private static final String getPage = "ProductDetailView";
	
	@Autowired
	private ProductDao productDao;
	
	//pnum을 통해 데이터 가지고 와서 이동
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doActionGet(@RequestParam(value = "pnum", required = true) int pnum, Model model) {
		
		System.out.println("ProductDetailView num : " + pnum);
		System.out.println("ProductDetailView Get 방식");
		
		Product product = productDao.GetData(pnum); //데이터 가지고 와서 Product 형식으로 담는다
		model.addAttribute("product", product); //Product 형식의 product를 product라는 이름으로 담아 이동
		
		return getPage; //ProductDetailView.jsp로 이동
	}

}
