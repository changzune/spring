package myspring.di.xml;

import java.util.List;

public class Hello {
	private String name;
	private Printer printer;
	private List<String> names;
	
	public Hello() {
		// TODO Auto-generated constructor stub
	}
	

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}


	public Hello(String name, myspring.di.xml.Printer printer) {
		super();
		this.name = name;
		this.printer = printer;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	public String sayHello() {
		return "Hello" + name;
	}
	
	public void print() {
		this.printer.print(sayHello());
	}
	
	
	
	

}
