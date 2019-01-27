package opinion.model;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.OpPaging;

@Component("MyOpinionDao")
public class OpinionDao {
	private static String namespace="opinion.model.Opinion";	
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public List<Opinion> selectById(String id) {
		List<Opinion> list=null;
		list=sqlSessionTemplate.selectList(namespace+".selectById", id);
		return list;
	}

	public int insertOpinion(Opinion opinion) {
		int cnt=0;
		cnt=sqlSessionTemplate.insert(namespace+".insertOpinion", opinion);
		return cnt;
	}

	public int getTotalCount() {
		int cnt=0;
		cnt=sqlSessionTemplate.selectOne(namespace+".getTotalCount");
		return cnt;
	}

	public List<Opinion> selectAllOpinion(OpPaging pageInfo) {
		List<Opinion> list=null;
		RowBounds rowBounds=new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		list=sqlSessionTemplate.selectList(namespace+".selectAllOpinion", null, rowBounds);
		return list;
	}

	public Opinion selectByOpnum(int opnum) {
		Opinion opinion=null;
		opinion=sqlSessionTemplate.selectOne(namespace+".selectByOpnum", opnum);
		return opinion;
	}

	public void deleteById(String id) {
		int cnt=0;
		cnt=sqlSessionTemplate.delete(namespace+".deleteById", id);
		System.out.println("secDelcnt:"+cnt);
		
	}

	public int replyOpinion(Opinion opinion) {
		int cnt=0;
		sqlSessionTemplate.update(namespace+".updateOpinionReply", opinion);
		cnt=sqlSessionTemplate.insert(namespace+".replyOpinion", opinion);
		return cnt;
	}

	public int deleteOpinion(int opnum) {
		int cnt=0;
		cnt=sqlSessionTemplate.delete(namespace+".deleteOpinion", opnum);
		return cnt;
	}
}
