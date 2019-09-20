package ktds.secure.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ktds.secure.test.service.SQLInjectionTestService;

@Controller
public class SQLInjectionTestController {
	@Autowired
	SQLInjectionTestService service;
	@RequestMapping("/secure/test")
	public String index(){
		return "main/secure";
	}
	@RequestMapping("/test1.do")
	public ModelAndView sqlInjecttionTest1(String id,String pass){
		StringBuffer br=new StringBuffer();
		br.append("ID,PASSWD 조회 결과:   " );
		String result = service.sqlInjection(id, pass);
		br.append(result);
		System.out.println(br.toString());
		ModelAndView mav = new ModelAndView();
		mav.addObject("result",br.toString());
		mav.setViewName("main/secure");
		return mav;
	}
}
