package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//setter 주입
//생성자 주입
//필드 주입 //@Autowired //쉐프 주입==연결

@Component
@ToString
@RequiredArgsConstructor
public class Restaurant {
	
	private final Chef chef;

}
