package com.sist.common;

// [로그 남기기]
// - 이 로그를 파일에 저장 ==> 로그 파일이 만들어지는 것.
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component // 메모리 할당 
@Aspect // 공통 기반 
public class LogAspect {
	
	@Around("execution(* com.sist.web.EmpController.*(..))") // EmpController에 등록된 모든 메소드   // execution: 호출하는 위치를 말함 
	public Object around(ProceedingJoinPoint jp) throws Throwable
	{
		System.out.println("사용자 요청 기능:"+jp.getSignature().getName());
		long start=System.currentTimeMillis(); // 시작 시간 
		Object obj=jp.proceed(); // proceed: 호출하는 메소드
		long end=System.currentTimeMillis(); // 종료 시간 
		System.out.println("수행시간: "+(end-start));
		System.out.println(jp.getSignature().getName()+": 종료");
		return obj;
	}
	

}
