package myspring.di.xml;

public class Hello {
	private String name;
	private printer printer;

	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrinter(printer printer) {
		this.printer = printer;
	}
	
	public String sayHello() {
		return "Hello" + name;
	}
	
	public void print() {
		this.printer.print(sayHello());
	}
	
	
	
	

}
