package ktds.erp.emp;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

public interface EmpService {
	ArrayList<MemberDTO> getTreeEmpList(String deptno);
	int insert(MemberDTO user,MultipartFile file,String realpath,String filename);
	public boolean idCheck(String id);
	ArrayList<MemberDTO> getMemberList();
	int delete(String id);
	MemberDTO read(String id);
	ArrayList<MemberDTO> search(String column, String search
					,String pass);
	int update(MemberDTO user);
	LoginDTO login(MemberDTO loginUser);
}
