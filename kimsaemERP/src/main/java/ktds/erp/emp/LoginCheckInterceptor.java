package ktds.erp.emp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession ses = request.getSession(false);
/*		String context = request.getContextPath();
		String requestUrl = request.getRequestURI();
		String path = requestUrl.substring(context.length());
		System.out.println(requestUrl.substring(context.length()));*/
		if(ses!=null) {
			LoginDTO user = (LoginDTO)ses.getAttribute("loginUser");
			if(user==null) {
				response.sendRedirect("/kimsaemERP/emp/login.do");
				return false;
			}
		}
		return true;
	}
	//뷰가 만들어지기 전
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}
	
}
