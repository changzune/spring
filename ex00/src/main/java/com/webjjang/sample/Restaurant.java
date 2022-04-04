package com.webjjang.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

//자동으로 생성이 되게하는 어노테이션
//@Controller - url과 관련, @Service - 처리, @Repository - DAO
//@Component - 구성, @RestController - url과 관련 순수데이터
@Component
//자동으로 생성자, setter, getter, toSting() 만들어주는 Lombok 어노테이션
@Data
public class Restaurant {
	
	//자동 DI를 적용시키는 어노테이션
	//@Inject - java, @AutoWirde - Spring, @Setter-Lombok
	
	@Setter(onMethod_ = @Autowired)
	private Chef chef;
	
	
	
	

}
