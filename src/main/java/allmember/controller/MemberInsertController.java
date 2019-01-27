package allmember.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import allmember.model.AllMember;
import allmember.model.AllMemberDao;

@Controller
public class MemberInsertController {
	private static final String command="/insert.mem";
	private static final String	getPage="MemberInsert";
	private static final String	gotoPage="Welcome";
	
	@Autowired
	ServletContext context;
	
	@Autowired
	@Qualifier("MyAllMemberDao")
	private AllMemberDao adao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String goInsertForm() {
		return getPage;
	}
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	public String goInsert(AllMember member,HttpServletResponse response) throws IOException {
		int cnt=0;
		System.out.println(member);
		member.setImg("basic.png");
		
		if(member.getEmail2().equals("insert")) {
			member.setEmail2(member.getEmail3());
		}
		cnt=adao.insertMember(member);
		
		if(cnt>0) {
			String dirs=context.getRealPath("/resources/img/"+member.getId()+"Profile");
			File Profile=new File(dirs);
			if(!Profile.exists()) {
				Profile.mkdirs();
			}
			return gotoPage;
		}else {
			return getPage;
		}
		
	}
}