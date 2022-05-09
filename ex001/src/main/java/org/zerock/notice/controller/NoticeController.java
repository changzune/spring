package org.zerock.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

//자동으로 생성이 되게 하는 어노테이션
//@Controller - url과 관련, @Service - 처리,  @Repository - DAO, @Component - 구성, @RestController - url과 ajax 관련 순수데이터
@Controller
@RequestMapping("/notice")
@Log4j
public class NoticeController {

	private final String MODULE = "notice";
	
	// 공지 리스트
	@GetMapping("/list.do")
	public String list() {
		log.info("--[공지 리스트]------------------------------------");
		return MODULE + "/" + "list"; 
	}
	// 공지 보기
	@GetMapping("/view.do")
	public String view() {
		log.info("--[공지 보기]------------------------------------");
		return MODULE + "/" + "view"; 
	}
	// 공지 쓰기 폼
	@GetMapping("/write.do")
	public String writeForm() {
		log.info("--[공지 쓰기 폼]------------------------------------");
		return MODULE + "/" + "write"; 
	}
	// 공지 쓰기 처리
	@PostMapping("/write.do")
	public String write() {
		log.info("--[공지 등록 처리]------------------------------------");
		return "redirect:list.do"; 
	}
	// 공지 수정 폼
	@GetMapping("/update.do")
	public String updateForm() {
		log.info("--[공지 수정 폼]------------------------------------");
		return MODULE + "/" + "update"; 
	}
	// 공지 수정 처리
	@PostMapping("/update.do")
	public String update() {
		log.info("--[공지 수정 처리]------------------------------------");
		return "redirect:view.do"; 
	}
	// 공지 삭제 처리 - get방식여야 하는데 post로 넘기면 405번 오류가 난다.
	@GetMapping("/delete.do")
	public String delete() {
		log.info("--[공지 삭제 처리]------------------------------------");
		return "redirect:list.do"; 
	}
	
}
