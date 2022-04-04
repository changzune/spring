package com.webjjang.sample;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


// Test할 프로그램 설정
@RunWith(SpringJUnit4ClassRunner.class)
// 실행할 때의 설정파일 -file: --> project 처음 위치에서 부터 찾는다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class SampleTest {

}
