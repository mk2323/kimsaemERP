package ktds.erp.emp.authentication;

import java.util.ArrayList;
import java.util.ServiceConfigurationError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ktds.erp.emp.EmpDAO;
import ktds.erp.emp.MemberDTO;

//로그인 인증 작업을 처리하는 서비스 클래스 - Spring security의클래스
public class LoginSecurityService implements UserDetailsService {
	@Autowired
	EmpDAO dao;
	@Autowired
	AuthorityDAO authDao;
	
	//dao의 메소드를 이용해서 입력받은 아이디에 해당하는 레코드가 있는지 확인한 후
	//조회한 사용자 정보를 UserDetails를 변환해서 리턴하는 메소드
	//=> 권한정보 추가
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUsername =========="+username);
		MemberDTO loginUser = dao.findbyId(username);
		System.out.println(loginUser);
		
		//db에서 조회한 MemberDTO를 UserDetails타입으로 변환해서 리턴
		//변환해서 리턴하지 않고 UserDetails을 상속하는 DTO를
		//직접만들어서 작업해도 좋다.
		//==> UserDetails을 구현하고 있는 User객체를 만들어서 리턴한다.
		// 1.User클래스는 id, password, 권한리스트를 매개변ㅅ로 받고 있으며
		// 2. 권한리시트는 여러 개가 될 수 있으므로 ArrayList에 담아서 리턴
		//3. ArrayList에 담는 권한 정보는 GrantedAuthority 객체타입이어야 
		//하고 GrantedAuthority는 인터페이스이므로 이 인터페이스를 
		//구현하고 SimpleGrantedAuthority객체를 생성해서 Arraylist에 추가한다.
		// 형식이 존재하는 이유는 내부에서 자동으로 처리하는 것이 있기 때문
		UserDetails securityLoginUser = null;
		
		ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		//dao에서 조회한 user별 권한리스트 이용해서 생성하기
		ArrayList<MemberAuthoritysDTO> list =(ArrayList<MemberAuthoritysDTO>)authDao.getAuthorityList(username);
		
		int size = list.size();
		
		for(int i=0; i<size; i++) {
			MemberAuthoritysDTO dto=list.get(i);
		 authorities.add(new SimpleGrantedAuthority(dto.getAuthorityname()));	
		}
		System.out.println("권한확인인인===="+authorities);
		
		
		//authorities.add(new SimpleGrantedAuthority(loginUser.getAuthority()));
		securityLoginUser = new User(loginUser.getId(), loginUser.getPass(), authorities);
		System.out.println("==========end========");
		return securityLoginUser;
	}

}
