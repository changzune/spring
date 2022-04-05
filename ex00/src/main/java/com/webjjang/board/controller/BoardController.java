package com.webjjang.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

//자동으로 생성이 되게하는 어노테이션
//@Controller - url과 관련, @Service - 처리, @Repository - DAO
//@Component - 구성, @RestController - url과 관련 순수데이터(ajax)

@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {

	private final String MODULE = "board";

	// url별 메서드 작성
	// 게시판 리스트
	@GetMapping("/list.do")
	public String list() {
		log.info(" ---게시판 리스트 ----");
		// /WEB-INF/views +board + / + list + .jsp
		return "MODULE" + "/" + "list";
	}

	// 게시판 글보기
	@GetMapping("/view.do")
	public String view() {
		log.info(" ---게시판 글보기 ----");
		// /WEB-INF/views +board + / + view + .jsp
		return "MODULE" + "/" + "view";
	}

	// 게시판 글쓰기 폼
	@GetMapping("/write.do")
	public String writeForm() {
		log.info(" ---게시판 글쓰기 폼 ----");
		// /WEB-INF/views +board + / + write + .jsp
		return "MODULE" + "/" + "write";
	}

	// 게시판 글쓰기 처리
	@PostMapping("/write.do")
	public String wirte() {
		log.info(" ---게시판 글쓰기 처리 ----");
		// 게시판 리스트로 보낸다.
		return "redirect:list.do";
	}

	// 게시판 글 수정 폼
	@GetMapping("/update.do")
	public String updateForm() {
		log.info(" ---게시판 글수정 폼 ----");
		// /WEB-INF/views +board + / + update + .jsp
		return "MODULE" + "/" + "update";
	}

	// 게시판 글 수정 처리
	@PostMapping("/update.do")
	public String update() {
		log.info(" ---게시판 글수정 처리 ----");
		//글보기로 자동이동
		return "redirect:view.do";
	}

	// 게시판 글삭제
	@PostMapping("/delect.do")
	public String delect() {
		log.info(" ---게시판 글삭제 ----");
		//글 리스트로 자동 이동
		return "redirect:list.do";
	}



}
