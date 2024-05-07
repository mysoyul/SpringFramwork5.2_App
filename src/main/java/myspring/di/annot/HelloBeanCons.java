package myspring.di.annot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloBeanCons {	
	String name;
	
	PrinterBean printer;
	
	List<String> names;
	
	@Autowired
	public HelloBeanCons(
			@Value("전략2생성자Injection") String name, 
			@Qualifier("consolePrinter") PrinterBean printer) {
		System.out.println(this.getClass().getName() + " Overloaded Constructor Called..");
		this.name = name;
		this.printer = printer;
	}

	public List<String> getNames() {
		return this.names;
	}

	public void setNames(List<String> list) {
		this.names = list;
	}


	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}
