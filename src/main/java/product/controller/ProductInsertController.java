package product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import product.model.Product;
import product.model.ProductDao;

@Controller
public class ProductInsertController {
	
	//회원은 추가못하지만 관리자 페이지 없어서 일단 회원이 상품 추가 할 수 있도록 함
	private static final String getPage = "ProductInsertForm";
	private static final String gotoPage = "redirect:/list.mt";
	private static final String command = "/insert.mt";
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doActionGet(HttpSession session) {
		
		System.out.println(this.getClass() + "GET방식 들어옴");
		System.out.println("logInfo : " + session.getAttribute("loginInfo"));
		
		if(session.getAttribute("loginInfo") == null) {
			
			session.setAttribute("destination", "redirect:/insert.mt");
			return "redirect:/login.mem";
		
		} else {
			
			return getPage;
		}//if ~ else
		
	}//
	
	//데이터 db에 입력하고 페이지 이동
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doActionPost(@ModelAttribute("product") @Valid Product product,
			BindingResult bindingResult, HttpSession session) {
		
		System.out.println(this.getClass() + "POST방식 들어옴");
		
		ModelAndView mav = new ModelAndView();
		
		System.out.println("servletContext.getRealPath('/')" + servletContext.getRealPath("/"));
		//C:\project\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Project_AllRecipe\
		
		String uploadPath = servletContext.getRealPath("/resources/mart/");
		System.out.println("uploadPath : " + uploadPath);
		// C:\project\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Project_AllRecipe\resources\mart\
		
		//유효성 검사
		if(bindingResult.hasErrors()) {
			
			System.out.println("ProductInsertController 유효성 검사 오류");
			
			mav.setViewName(getPage);// 오류 있으면 ProductInsertForm.jsp로 이동, 재작성
			return mav;
		}
		
		MultipartFile multi = product.getUploadpimage();
		//multi에는 uploadpimage 정보가 들어간다
		
		System.out.println("product.getUploadpimage() : "+ product.getUploadpimage());
		System.out.println("product.getPimage() : " +product.getPimage());
		
		Integer cnt = -1;
		cnt = productDao.InsertData(product);
		
		if(cnt != -1) { // 데이터  업로드 성공
			
			mav.setViewName(gotoPage); //redirect:/list.mt

			File destination = new File(uploadPath + File.separator + multi.getOriginalFilename());
			// C:\Spring_ysy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Project_Allrecipe\resources\mart\파일이름.jpg
			
			/*
			실제 화일이 올라가는 위치
			C:\Spring_ysy\.metadata\.plugins\org.eclipse.wst.server.core\tmp3\wtpwebapps\Project_Allrecipe\resources\mart
			*/
			
			try {
				multi.transferTo(destination);// transferTo:원하는 위치에 저장할 때 사용
				//File 객체를 만든 뒤 MultipartFile 객체의 transferTo 메서드를 실행시켜 실제 물리적인 파일을 만든다.
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("업로드 성공");
			
		} else { // 업로드 실패
			
			System.out.println("업로드 실패");
			mav.setViewName(getPage); //ProductInsertForm.jsp
			
		}//if~ else
		
		return mav;
		
	}//

}
