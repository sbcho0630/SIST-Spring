package com.sist.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// XML 파싱 
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		// ApplicationContext: 클래스 관리자. 
		// 메모리 생성과 소멸은 Spring이 알아서 해줌 
		
		// 등록된 클래스를 사용
		//Sawon sa=(Sawon)app.getBean("sa"); // .getBean("bean id")
		//sa.display();
		//sa.setSabun(1);
		//sa.setName("홍길동");
		//sa.setDept("개발부");
		
		//Sawon sa1=(Sawon)app.getBean("sa");
		//sa1.display(); 
		//sa1.setSabun(2);
		//sa1.setName("심청이");
		//sa1.setDept("영업부");
		
		// [app.xml에서 <bean id="sa">일 때 (기본설정): 싱글톤]
		// - sa,sa1이 같은 주소를 쓴다! 메모리 생성을 하나만 해주는군!! ==> ★★★"싱글톤"★★★
		//System.out.println("sa="+sa);
		//System.out.println("sa1="+sa1);
		//System.out.println("sa의 이름="+sa.getName()); // 심청이  - 같은 주소를 쓰기 때문에 sa1을 바꿔도 sa의 이름도 바뀜 
		
		
		// ex) 주소값 하나만 쓰기 
		// 	   A a=new A(); 
		//     A b=a; 
		//     ==> a와 b는 주소값 하나를 쓴다. 
		
		// ex) 주소값 다르게 
		//     A a=new A();
		//     A b=new A();
		//     ==> a와 b는 주소값을 각자 따로 쓴다. 
		
		// [app.xml에서 <bean id="sa" scope="prototype">으로 바꿨을 때]
		// - sa,sa1이 다른 주소를 쓴다! 
		// Spring에서도 메모리를 따로 쓸 수도 있다. ==> app.xml에서 bean 등록 시, scope를 singleton(디폴트값)이 아니라, prototype을 쓰면 됨.
		//System.out.println("sa="+sa);
		//System.out.println("sa1="+sa1);
		
		// DI - Dependency Injection 
		// - app.xml에서 값을 주입했음 ★
		// - 이렇게, 값을 Spring에서 주입하는 것을 DI라고 함. 
		/*System.out.println("sa="+sa);
		System.out.println("사번:"+sa.getSabun());
		System.out.println("이름:"+sa.getName());
		System.out.println("부서:"+sa.getDept());*/
		
		
		// Sawon sa=(Sawon)app.getBean("sa3");
		// Sawon sa=(Sawon)app.getBean("sa4");
		Sawon sa=(Sawon)app.getBean("sa5");
		System.out.println("sa3="+sa);
		System.out.println("사번:"+sa.getSabun());
		System.out.println("이름:"+sa.getName());
		System.out.println("부서:"+sa.getDept());
	}

}





