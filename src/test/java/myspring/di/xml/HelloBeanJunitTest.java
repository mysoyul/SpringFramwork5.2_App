package myspring.di.xml;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloBeanJunitTest {
	@Test
	void hello() {
		String str1 = "Hello Junit!";
		Assertions.assertEquals("Hello Junit!", str1);
	}
}
