package com.webjjang.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


// Test할 프로그램 설정
@RunWith(SpringJUnit4ClassRunner.class)
// 실행할 때의 설정파일 -file: --> project 처음 위치에서 부터 찾는다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
// syso 대신에 서버 콘솔에 찍거나 로그로 남길 때 사용하는 객체
@Log4j
public class SampleTest {
	
	// 자동 DI를 적용시키는 어노테이션
	//@Inject - java, @AutoWirde - Spring, @Setter - Lombok
	@Setter(onMethod_ = @Autowired)
	private Restaurant restaurant;
	
	//테스트를 할 매세드를 정의하는 어노테이션 - 단위테스트
	@Test
	public void testExist() {
		log.info("--------------------------------------");
		//Restaurant 객체가 생성이 됐는지? DI를 적용해서 SampleTest 객체에 넣어 줬는지? 확인 
		log.info(restaurant);
		// chef 객체 생성이 되는지 확인
		
	}
	//테스트를 할 매세드를 정의하는 어노테이션 - 단위테스트
	@Test
	public void testExistChef() {
		log.info("--------------------------------------");
		//Restaurant 객체가 생성이 됐는지? DI를 적용해서 SampleTest 객체에 넣어 줬는지? 확인 
		log.info(restaurant.getChef());
		
	}
	
	
	

}
