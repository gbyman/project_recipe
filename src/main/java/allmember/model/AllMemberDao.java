package allmember.model;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("MyAllMemberDao")
public class AllMemberDao {
	private static String namespace="allmember.model.AllMember";	
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public int idcheck(String id) {
		int cnt=0;
		cnt=sqlSessionTemplate.selectOne(namespace+".idcheck", id);
		return cnt;
	}
	public int insertMember(AllMember member) {
		int cnt=0;
		cnt=sqlSessionTemplate.insert(namespace+".insertMember", member);
		return cnt;
	}
	public AllMember LoginSelect(Map<String, String> map) {
		AllMember member=null;
		member=sqlSessionTemplate.selectOne(namespace+".LoginSelect", map);
		return member;
	}
	public AllMember Findid(AllMember member) {
		AllMember bean=null;
		bean=sqlSessionTemplate.selectOne(namespace+".Findid", member);
		return bean;
	}
	public AllMember FindPw(AllMember member) {
		AllMember bean=null;
		bean=sqlSessionTemplate.selectOne(namespace+".Findpw", member);
		return bean;
	}
	public int updateMemberInfo(AllMember allmember) {
		int cnt=0;
		cnt=sqlSessionTemplate.update(namespace+".updateMemberInfo", allmember);
		return cnt;
	}
	public int updateMemberPasswd(Map<String, String> map) {
		int cnt=0;
		cnt=sqlSessionTemplate.update(namespace+".updateMemberPasswd", map);
		return cnt;
	}
	public int updateProfile(Map<String, String> map) {
		int cnt=0;
		cnt=sqlSessionTemplate.update(namespace+".updateProfile", map);
		return cnt;
	}
	public int deleteMember(String id) {
		int cnt=0;
		cnt=sqlSessionTemplate.delete(namespace+".deleteMember", id);
		return cnt;
	}
	
	
	
}
