package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanJunitTest {
	ApplicationContext context;
	
	@Test @Disabled
	void hello() {
		String str1 = "Hello Junit!";
		assertEquals("Hello Junit!", str1);
	}
	
	@BeforeEach
	void init() {
		//Spring Bean Container 객체생성
		context = new GenericXmlApplicationContext("classpath:spring_di.xml");	
	}
	
	@Test
	void helloBean() {
		//Container에게 Hello Bean을 요청하기
		Hello helloBean1 = (Hello)context.getBean("hello");
		Hello helloBean2 = context.getBean("hello", Hello.class);
		
		//Hello Bean이 Singleton Object 인지 확인
		//Reference 비교
		System.out.println(helloBean1 == helloBean2);
		assertSame(helloBean1, helloBean2);
		
		//setName() 메서드 호출이 정상인지 확인
		assertEquals("Hello Spring", helloBean1.sayHello());
		
		//setPrinter() 메서드 호출이 정상인지 확인
		helloBean1.print();
		
		//Container에게 StringPrinter Bean을 요청하기
		Printer printer = context.getBean("strPrinter", Printer.class);
		assertEquals("Hello Spring", printer.toString());
	}
	
}
