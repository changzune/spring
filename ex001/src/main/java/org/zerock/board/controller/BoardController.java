package org.zerock.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;
import oracle.jdbc.proxy.annotation.Post;

//자동으로 생성이 되게 하는 어노테이션
//@Controller -URL과 관련, @Service -처리, @Repository - DAO, @Component - 구성,
//@Restcontroller -url관련 순수데이터 전달할때 사용한다. ajax사용할 때 사용한다.

@Controller
@RequestMapping("/board") //상위의 url이 BOARD이다.
@Log4j //롬복 나오게 하기
public class BoardController {
	
	private final String Module = "board";
	
	//url별 메소드 작성
	
	// 게시판 리스트
	@GetMapping("/list.do")
	public String list() {
		log.info("----[게시판 리스트]-------------------------");
		// WEB_INF/views + board + / + list + .jsp
		return Module + "/" + "list";
	}
	
	//게시판 글보기
	@GetMapping("/list.do")
	public String view() {
		log.info("----[게시판 글보기]-------------------------");
		// WEB_INF/views + board + / + view + .jsp
		return Module + "/" + "view";
	}
	
	//게시판 글쓰기 폼
	@GetMapping("/write.do")
	public String writeForm() {
		log.info("----[게시판 글쓰기 폼]-------------------------");
		// WEB_INF/views + board + / + write + .jsp
		return Module + "/" + "write";
	}
	
	//게시판 글쓰기 처리
	@PostMapping("/write.do")
	public String write() {
		log.info("----[게시판 글쓰기 처리]-------------------------");
		// WEB_INF/views + board + / + list + .jsp
		// 게시판 리스트로 보낸다.
		return "redirect:list.do";
	}
	
	//게시판 글수정 폼
	@GetMapping("/update.do")
	public String updateForm() {
		log.info("----[게시판 글수정 폼]-------------------------");
		// WEB_INF/views + board + / + update + .jsp
		return Module + "/" + "update";
	}
	
	//게시판 글 수정 처리
	@PostMapping("/update.do")
	public String update() {
		log.info("----[게시판 글수정 처리]-------------------------");
		// WEB_INF/views + board + / + list + .jsp
		// 글보기로 자동으롱 ㅣ동
		return "response:viwe.do";
	}
	
	//게시판 글 삭제
	@PostMapping("/delete.do")
	public String delete() {
		log.info("----[게시판 글 삭제]-------------------------");
		// 글 리스토로 자동이동
		return "redirect:list.do";
	}
	

	

}
