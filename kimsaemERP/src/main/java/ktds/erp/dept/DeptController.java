package ktds.erp.dept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeptController {
	@Autowired
	DeptService service;
	
	@RequestMapping("/dept/tree.do")
	public String getDeptList() {
		return "dept/tree";
	}
}
