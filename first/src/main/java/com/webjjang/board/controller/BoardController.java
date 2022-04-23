package com.webjjang.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	//실행할 메서드
	public String list() {
		System.out.println("BoardController.list.()");
		
		return "board/list";
	}

}
