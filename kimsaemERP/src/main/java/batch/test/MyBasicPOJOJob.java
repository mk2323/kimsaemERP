package batch.test;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service("myservicejob")
public class MyBasicPOJOJob {
	public void test() {
		//실제 주기적으로 처리하고 싶은 일		
		System.out.println("주기적으로 처리할 일을정의 ....POJO");
		System.out.println(new Date());
	}

}
