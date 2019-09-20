package ktds.erp.emp.security.loginPolicy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SecurityLoginPolicyServiceImpl implements SecurityLoginPolicyService{
	@Autowired
	SecurityLoginPolicyDAO dao;

	@Override
	public void setPasswordState() {
		//스케쥴러에서 매일 새벽 1시에 호출ㅇ할 메소드
		//dao의 메소드를 호출해서 패스워드 변경 날짜가 지난 회원들의
		//passchangestate값을 Y로 변경하기
		
	}

}
