package myspring.di.xml;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring_di.xml")
public class HelloBeanSpringTest {
	@Autowired
	Hello hello;
	
	@Autowired
	@Qualifier("helloCons")
	Hello hello2;
	
	@Resource(name = "helloCons")
	Hello hello3;
	
	@Test
	void helloBean() {
		System.out.println(hello.sayHello());
		System.out.println(hello2.sayHello());
		System.out.println(hello3.sayHello());
	}
	
}
