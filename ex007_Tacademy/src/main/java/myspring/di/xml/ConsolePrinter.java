package myspring.di.xml;

public class ConsolePrinter implements printer {

	@Override
	public void print(String message) {
		System.out.println(message);
		
	}

}
