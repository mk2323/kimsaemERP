package batch.test;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MyBasicJob extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		//실제 주기적으로 처리하고 싶은 일
		System.out.println("주기적으로 처리할 일을정의 ....");
		System.out.println(new Date());
	}
	
	
}
