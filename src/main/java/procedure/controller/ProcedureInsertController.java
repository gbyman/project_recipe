package procedure.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import procedure.model.Procedure;
import procedure.model.ProcedureDao;

@Controller
public class ProcedureInsertController {
	private static final String command="/procedureInsert.rec";
	
	@Autowired
	private ProcedureDao proDao;
	
	@Autowired
	ServletContext context;
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	@ResponseBody
	private int insertProcedure(Procedure procedure) {
		int cnt=0;
		System.out.println(procedure);
		MultipartFile multi=procedure.getProUpload();
		if(multi.getSize()==0) {
			procedure.setProimage("basicRecipe.jpg");
		}
		
		String upDir=context.getRealPath("/resources/procedure/"+procedure.getRecnum());
		File upfolder=new File(upDir);
		if(!upfolder.exists()) {
			upfolder.mkdir();
		}
		
		cnt=proDao.insertProcedure(procedure);
		if(cnt>0) {
			if(multi.getSize()>0) {
				File upload=new File(upDir+File.separator+multi.getOriginalFilename());
				try {
					multi.transferTo(upload);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return cnt;
	}
}
