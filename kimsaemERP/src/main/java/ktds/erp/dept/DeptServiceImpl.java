package ktds.erp.dept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	DeptDAO dao;

	
	@Override
	public List<DeptDTO> getDeptlist() {
		return dao.getDeptlist();
	}

	
	
}
