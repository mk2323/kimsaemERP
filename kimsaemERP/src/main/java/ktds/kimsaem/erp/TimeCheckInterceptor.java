package ktds.kimsaem.erp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//컨트롤러가 실행되는 시간(접속ip)을 측정
public class TimeCheckInterceptor extends HandlerInterceptorAdapter {
	private long start;
	private long end;
	//컨트롤러 시작전
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("==========preHandle==============");
		System.out.println("접속한 ip:"+request.getRemoteHost());
		start = System.nanoTime();
		return true;//	
	}
	//컨트롤러 실행 후
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		end = System.nanoTime();
		System.out.println("==============postHandle===========");
		String handlerClass= handler.getClass().getName();
		System.out.println(handlerClass+":실행시간=>"+(end-start));
	}

	
	
}
