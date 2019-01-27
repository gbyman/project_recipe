package procedure.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import procedure.model.Procedure;
import procedure.model.ProcedureDao;

@Controller
public class ProcedureListController {
	private static final String command="/procudureList.rec";
	
	@Autowired
	private ProcedureDao proDao;
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	private void getProcedureList(
			@RequestParam("recnum")int recnum,HttpServletResponse response,HttpServletRequest request
			) {
		List<Procedure> list=proDao.selectByRecnum(recnum);
		String contextPath=request.getContextPath();
		String str="";
		int count=1;
		PrintWriter writer;
		response.setContentType("text/html;charset=UTF-8");
		try {
			writer=response.getWriter();
		
			for(Procedure pro:list) {
				str+="<table width='100%' ><tr>"+
	        		"<td align='center' width='70%'>"+count+". "+pro.getProcontent()+"</td>"+
	        		"<td align='center'>"+
	        		"<img src='"+contextPath+"/resources/procedure/"+pro.getRecnum()+"/"+pro.getProimage()+"' alt='파일첨부' width='200' height='200'/></td></tr></table>";
				count++;
			}
			writer.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
