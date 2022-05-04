package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

//자동으로 생성이 되게 하는 어노테이션
//@Controller -URL과 관련, @Service -처리, @Repository - DAO, @component - 구성,
//@Restcontroller -url관련 순수데이터 전달할때 사용한다. ajax사용할 때 사용한다.

@Component
//자동으로 생성자 세터게터를 투스트링 ()만들어주는 Lombok 어노테이션
@Data
public class Restaurant {
	
	// 자동 DI를 적용시키는 어노테이션
	// @Inject - java 라이브러리 @AutoWired - Spring, @Setter-lombok
	
	@Setter(onMethod_ = @Autowired)
	private Chef chef;
	

}
