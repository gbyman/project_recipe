package product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;



import product.model.Product;
import product.model.ProductDao;
//관리자 페이지 구현 전 : 회원이 상품 올리고 수정가능
@Controller
public class ProductUpdateController {
	
	private static final String command = "update.mt";
	private static final String gotoPage = "redirect:/list.mt";
	private static final String getPage = "ProductUpdateForm";
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private ProductDao productDao;
	
	//ProductDetailView.jsp에서 수정하기 버튼 누르면 GET방식으로 넘어온다
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doActionGet(HttpSession session, @RequestParam(value = "pnum", required = true) int pnum, Model model) {
		
		//로그인 안한 사람이 수정하기 누르면 로그인 화면으로 이동
		if(session.getAttribute("loginInfo") == null) {
			
			session.setAttribute("destination", "redirect:/update.mt?pnum="+pnum);
			return "redirect:login.mem";
			
		} else { //로그인 되어 있다면 ProductUpdateForm.jsp로 이동
			
			Product product = productDao.GetData(pnum);
			System.out.println("product.pname : " + product.getPname());
			
			model.addAttribute("product", product);
			return getPage;
		
		}//if ~ else
	}
	
	//ProductUpdateForm.jsp에서 post방식으로 넘어옴
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doActionPost(Product product) {
		
		System.out.println("ProductUpdateController Post방식");
		
		MultipartFile multi = product.getUploadpimage();
		//multi에는 uploadpimage 정보가 들어간다
		
		System.out.println("product.getUploadpimage() : "+ product.getUploadpimage());
		System.out.println("product.getPimage() : " +product.getPimage());
		
		String uploadDir = servletContext.getRealPath("/resources/mart/");
		//파일 업로드 되어 있는 폴더 주소
		System.out.println("ProductUpdateController uploadDir : " + uploadDir);
		
		File delUploadpimage = new File(uploadDir + File.separator + product.getPimage());
		//기존 파일 삭제할 준비
		
		ModelAndView mav = new ModelAndView();
		
		Integer cnt = -1;
		cnt = productDao.UpdateData(product);
		System.out.println(cnt);
		
		//수정 성공
		if(cnt != -1) {
			
			//수정 성공 후 기존의 이미지 삭제
			delUploadpimage.delete();
			
			//기존 이미지 삭제 후 새로 수정한 파일을 파일이름으로 이미지 저장 폴더에 저장
			File destination = new File(uploadDir + File.separator + multi.getOriginalFilename());
			System.out.println("upload destination : " + destination);
			
			try {//파일 이름으로 저장
				multi.transferTo(destination);
			} catch (IllegalStateException e) {
				System.out.println("productupdate ISE");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("productupdate IOException");
				e.printStackTrace();
			}
			
			mav.setViewName(gotoPage);// 기존 이미지 삭제하고 redirect:/list.mt로 이동
			
		} else { //수정 실패 후 ProductUpdateForm.jsp로 이동
			
			mav.setViewName(getPage); // ProductUpdateForm.jsp로 이동
			
		}//if ~ else
		
		return mav;
		
	}
}
