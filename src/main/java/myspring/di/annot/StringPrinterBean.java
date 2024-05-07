package myspring.di.annot;

import org.springframework.stereotype.Component;

@Component("stringPrinter")
public class StringPrinterBean implements PrinterBean {
	private StringBuffer buffer = new StringBuffer();

	public StringPrinterBean() {
		System.out.println(this.getClass().getName() + " Constructor Called..");
	}
	
	public void print(String message) {
		this.buffer.append(message);
	}

	public String toString() {
		return this.buffer.toString();
	}
}
