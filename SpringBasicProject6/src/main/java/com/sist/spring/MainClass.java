package com.sist.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;
import com.sist.dao.*;

// <Main에서 DAO 쓰는 법> 
// [방법2]. Spring 이용 (참고: 방법1은 SpringBasicProject5의  com.sist.spring > MainClass 참고) 
@Component
public class MainClass {

	@Autowired
	private EmpDAO dao; 
	
	@PostConstruct // 메소드 DI(init-메소드) 
	public void init()
	{
		System.out.println("============== 사원 정보 ==============");
	}
	
	@PreDestroy // 메소드 DI(destroy-메소드) 
	public void destroy()
	{
		System.out.println("============== 프로그램 종료 ==============");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 일반적 - 종료가 따로 없음  
		// ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		
		// Generic~~ - 메모리 해제가 가능 ==> app.close(); 하면 메모리 해제됨 
		GenericXmlApplicationContext app=new GenericXmlApplicationContext("app.xml");
		MainClass mc=(MainClass)app.getBean("mainClass");
		System.out.println(mc.dao);
		
		EmpVO vo=mc.dao.empFindData(7788);
		System.out.println("사번: "+vo.getEmpno());
		System.out.println("이름: "+vo.getEname());
		System.out.println("직위: "+vo.getJob());
		System.out.println("입사일: "+vo.getHiredate());
		System.out.println("급여: "+vo.getSal());
		
		app.close(); // 메모리 해제 
	}

}


/* 
 * [클래스 메모리 할당]
 * : @Component, @Repository, @Service, @Controller, @RestController, @ControllerAdvice 
 * 
 * [주입(DI)]
 * : @Required, @Autowired, @PostConstruct, @PreDestroy, @Resource 
*/




