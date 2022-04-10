package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

//인터페이스타입을 쓰면 실제 객체를 몰라도 된다.
@Component // 기본적으로 컴포넌트가 있으면 객체로 만들어서 가지고 관리를 해야 한다.
@Data
public class Chef {
	
	private Chef chef;

}
