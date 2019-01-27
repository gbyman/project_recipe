package talk.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("MyTalkDao")
public class TalkDao {
	private static String namespace="talk.model.Talk";	
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public List<TalkContainer> TalkList(int offset) {
		List<TalkContainer> list=new ArrayList<TalkContainer>();
		RowBounds rowBounds=new RowBounds(offset, 5);
		list=sqlSessionTemplate.selectList(namespace+".TalkList", null, rowBounds);
		return list;
	}

	public TalkContainer containerByTid(int tnum) {
		TalkContainer talkContainer=null;
		talkContainer=sqlSessionTemplate.selectOne(namespace+".containerByTid", tnum);
		return talkContainer;
	}

	public int TalkInsert(Talk talk) {
		int cnt=0;
		cnt=sqlSessionTemplate.insert(namespace+".TalkInsert", talk);
		return cnt;
	}

	public Talk selectByTnum(int tnum) {
		Talk talk=null;
		talk=sqlSessionTemplate.selectOne(namespace+".selectByTnum", tnum);
		return talk;
	}

	public int updateTalk(Talk talk) {
		int cnt=0;
		cnt=sqlSessionTemplate.update(namespace+".updateTalk", talk);
		return cnt;
	}

	public int deleteTalk(int tnum) {
		int cnt=0;
		cnt=sqlSessionTemplate.delete(namespace+".deleteTalk", tnum);
		return cnt;
	}

	public List<Talk> selectById(String id) {
		List<Talk>list=null;
		list=sqlSessionTemplate.selectList(namespace+".selectById", id);
		return list;
	}

	public void deleteById(String id) {
		int cnt=0;
		cnt=sqlSessionTemplate.delete(namespace+".deleteById", id);
		System.out.println("secDelcnt:"+cnt);
		
	}

	public int getCountByImage(String img) {
		int cnt=0;
		cnt=sqlSessionTemplate.selectOne(namespace+".getCountByImage", img);
		return cnt;
	}
	
}
