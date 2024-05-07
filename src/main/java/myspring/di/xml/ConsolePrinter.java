package myspring.di.xml;

public class ConsolePrinter implements Printer {
	public ConsolePrinter() {
		System.out.println(this.getClass().getName() + " Constructor Called..");
	}
	
	public void print(String message) {
		System.out.println(message);
	}
}
