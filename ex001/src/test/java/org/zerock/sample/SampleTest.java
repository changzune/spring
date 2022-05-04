package org.zerock.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

// test할 프로그램 설정
@RunWith(SpringJUnit4ClassRunner.class)
// 실행할 때의 설정 파일 - file: --> project 처음 위치에서부터 찾는다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
// syso 대신에 서버 콘솔 찍거나 로그로 남길 때 사용하는 객체. log.info(~~~); log.wring(); log.error();
@Log4j
public class SampleTest {
	
	@Setter(onMethod_ = @Autowired)
	private Restaurant restaurant;
	
	
	//test할 메서드를 정의하는 어노테이션- 단위테스트를 했다.
	@Test
	public void testExist() {
		log.info("-------------------------------------");
		//Restaurant 객체가 생성이 됐는지? DI를 적용해서 SampleTest 객체에 넣어 줬는지? 확인
		log.info(restaurant);
		//chef 객체  객체가 생성이 됐는지? DI를 적용해서 Restaurant 객체에 넣어 줬는지? 확인
	}
	
	@Test
	public void testExistChef() {
		log.info("-------------------------------------");
		log.info(restaurant.getChef());
		
	}
	

}
