package ktds.secure.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ktds.secure.test.dao.SQLInjectionTestDAO;

@Service
public class SQLInjectionTestService {
	@Autowired
	SQLInjectionTestDAO dao;
	public String sqlInjection(String id,String pass){
		System.out.println("service");
		return dao.sqlInjection(id, pass);
	}
}
