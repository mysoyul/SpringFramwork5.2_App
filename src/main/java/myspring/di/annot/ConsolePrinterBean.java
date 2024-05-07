package myspring.di.annot;

import org.springframework.stereotype.Component;

@Component("consolePrinter")
public class ConsolePrinterBean implements PrinterBean {
	public ConsolePrinterBean() {
		System.out.println(this.getClass().getName() + " Constructor Called..");
	}
	
	public void print(String message) {
		System.out.println(message);
	}
}
