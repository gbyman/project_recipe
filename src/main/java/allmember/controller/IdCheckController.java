package allmember.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import allmember.model.AllMemberDao;

@Controller
public class IdCheckController {
	private static final String command="/idcheck.mem";
	
	@Autowired
	private AllMemberDao adao;
	
	
	@RequestMapping(value=command)
	@ResponseBody
	public String idcheck(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String id=request.getParameter("userId");
		
		String str="";
		int cnt=adao.idcheck(id);
		
		if(cnt>0) {
			str="YES";
		}else {
			str="NO";
		}
		
		return str;
	}
	
}