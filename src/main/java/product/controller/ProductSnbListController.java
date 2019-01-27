package product.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import product.model.Product;
import product.model.ProductDao;
import reply.model.Reply;

@Controller
@RequestMapping("/product")
public class ProductSnbListController {

	@Autowired
	private ProductDao proDao;
	
	@RequestMapping(value="/list.mt")
	private void goList(HttpServletResponse response) {
		
		List<Product>list=proDao.GetDataList();
		
		String str="";
		try {
			PrintWriter writer;
			response.setContentType("text/html;charset=UTF-8");
			writer=response.getWriter();
			
			for(Product a:list) {
				str+="<div class='col-md-3 col-sm-6 mb-4'>"+
	            "<a class='portfolio-box' href='resources/mart/"+a.getPimage()+"'>"+
	              "<img class='img-fluid' src='resources/mart/"+a.getPimage()+"' width='500' height='500'>"+
	              "<div class='portfolio-box-caption'>"+
	                "<div class='portfolio-box-caption-content'>"+
	                  "<div class='project-category text-faded'>"+a.getPname()+
	                  "</div>"+
	                  "<div class='project-name'>"+
	                   a.getPrice()+"원"+
	                  "</div></div></div></a></div>";
	        
			}
			writer.println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}
