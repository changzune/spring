package myspring.di.xml.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.format.Printer;

import myspring.di.xml.Hello;


public class HelloBeanTest {

	public static void main(String[] args) {
		//1.Ioc 컨테이너 생성
		ApplicationContext context = new GenericXmlApplicationContext("config/beans.xml");
		//2. hello bean 가져오기
		Hello hello = (Hello)context.getBean("hello");
		System.out.println(hello.sayHello());
		hello.print();
		//3.StringPriter Bean 가져오기
	
		Printer printer = context.getBean("Printer",Printer.class);
		System.out.println(printer.toString());
		
	}

}
