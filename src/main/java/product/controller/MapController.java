package product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MapController {
	
	@RequestMapping(value="/martMap.mt")
	//메뉴에서 올맛집 선택하면 Map.jsp로 이동
	public String goMap() {
		
		return "Map";
	}
}
