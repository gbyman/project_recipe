package allmember.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import allmember.model.AllMemberDao;

@Controller
public class ProfileController {
	
	private static final String command="/profile.mem";
	private static final String getPage="Profile";
	
	@Autowired
	ServletContext context;
	
	@Autowired
	private AllMemberDao aDao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	private String goProfile(
			@RequestParam("img") String img,
			@RequestParam("tid") String tid,
			Model model
			) {
		model.addAttribute("img", img);
		model.addAttribute("tid", tid);
		return getPage;
	}
	@RequestMapping(value=command,method=RequestMethod.POST)
	private void goProfileUpdate(
			@RequestParam("tid")String tid,
			@RequestParam(value="newfile",required=false)MultipartFile upload,
			@RequestParam("img")String img,
			HttpServletResponse response ,
			HttpServletRequest request
			) throws IllegalStateException, IOException {
		String imgUrl=upload.getOriginalFilename();
		PrintWriter writer=null;
		response.setContentType("text/html;chatset=UTF-8");
		writer=response.getWriter();
		
		if(upload.getSize()==0) {
			imgUrl="basic.png";
		}
		
		Map<String, String>map=new HashMap<>();
		map.put("id", tid);
		map.put("img", imgUrl);
		
		if(imgUrl.equals(img)) {
			writer.println("<script type='text/javascript'>");
			writer.println("alert('이전사진과 같은 사진입니다.')");
			writer.println("history.back()");
			writer.println("</script>");
			writer.flush();
			writer.close();
		}
		
		int cnt=aDao.updateProfile(map);
		
		
		if(cnt>0) {
			String dirs=context.getRealPath("/resources/img/"+tid+"Profile");
			
			File dirsFile=new File(dirs);
			if(!dirsFile.exists()) {
				dirsFile.mkdirs();
			}
			File del=new File(dirs+File.separator+img);
			del.delete();
			
			File file=new File(dirs+File.separator+imgUrl);
			upload.transferTo(file);
			
			writer.println("<script type='text/javascript'>");
			writer.println("alert('프로필 사진을 수정하였습니다.')");
			writer.println("opener.location.reload()");
			writer.println("self.close()");
			writer.println("</script>");
			writer.flush();
			writer.close();
		}else {
			writer.println("<script type='text/javascript'>");
			writer.println("alert('수정에 실패했습니다.')");
			writer.println("history.back()");
			writer.println("</script>");
			writer.flush();
			writer.close();
		}
		
	}
	
}
