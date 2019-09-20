package ktds.erp.emp.security.loginPolicy;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ktds.erp.emp.MemberDTO;
@Repository
public class SecurityLoginPolicyDAOImpl implements SecurityLoginPolicyDAO {
	@Autowired
	SqlSession sqlSession;
	@Override
	public List<PassHistoryDTO> getPasswordChangeList() {
		//패스워드 변경한 마지막 날짜가 오늘날짜로 부터 한달이 지난 사원들의
		//목록을 조회할 수 있도록 mapper호출
		
		
		return sqlSession.selectList("ktds.erp.emp.login.passchangelist");
	}
	@Override
	public int update(List<PassHistoryDTO> userlist) {
		//getPasswordChangeList에서 조회한 목록 안의 dto의
		//passchangestate을 바꿀 수 있도록 mapper호출
		//단, userlist안의 모든 사원의 값을 바꿀 수 있도록 반복처리
		

		return 0;
	}
	

}
