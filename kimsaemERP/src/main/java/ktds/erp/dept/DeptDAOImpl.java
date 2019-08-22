package ktds.erp.dept;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class DeptDAOImpl implements DeptDAO {
	@Autowired
	SqlSession sqlSession;


	@Override
	public List<DeptDTO> getDeptlist() {
		return sqlSession.selectList("ktds.erp.dept.selectAll");
	}
	
}
