package myspring.di.xml;

public class Consoleprinter implements printer {

	@Override
	public void print(String message) {
		System.out.println(message);
		
	}

}
