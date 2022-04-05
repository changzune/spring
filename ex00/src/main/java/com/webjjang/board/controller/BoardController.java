package com.webjjang.board.controller;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.webjjang.board.vo.BoardVO;

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
		log.info("---게시판 리스트 -------------------------");
		// /WEB-INF/views + board + / + list + .jsp
		return MODULE + "/" + "list";
	}

	// 게시판 글보기
	@GetMapping("/view.do")
	//글번호가 필요하다. request에서 꺼내는 방식(예전), 지금은 spring의 DispacherServlet이 자동으로 매칭되는 것을 꺼내서 전달해준다.
	// 처리된 데이터(DB 가져오는 데어터 : 강제)는 Model에 담으면 되는데 Model을 파라메터로 받는다.
	// no : long type인 경우는 데이터가 넘어오지 않더라도 null이 가능해서 오류가 니지 않는다.
	// 		그런데 기본형 타입인 long인 경우 - String 데이터를 받아서 Long.parseLong(String) Number 타입이 아니고 저장 할수
	// 없어서 오류가 난다. -> 꼭 필요한 데이터는 오류를 내고 오류처리를 해주세요.
	public String view(long no,@RequestParam(defaultValue = "0") int inc,@ModelAttribute("page") Long page , Model model) {
		log.info(" ---게시판 글보기 ----");
		log.info("글번호 : " + no + ",증가:" + inc);
		page = 11L;
		BoardVO vo = new BoardVO();
		vo.setNo(10L);
		vo.setTitle("test");
		vo.setContent("test test");
		vo.setWriter("lee");
		
		//jps에 전달하기 위해서 model에 데이터는 저장해 놓는다.
		model.addAttribute("vo", vo);
		
		// /WEB-INF/views +board + / + view + .jsp
		return MODULE + "/" + "view";
	}

	// 게시판 글쓰기 폼
	@GetMapping("/write.do")
	public String writeForm() {
		log.info(" ---게시판 글쓰기 폼 ----");
		// /WEB-INF/views +board + / + write + .jsp
		return MODULE + "/" + "write";
	}

	// 게시판 글쓰기 처리
	@PostMapping("/write.do")
	public String wirte(BoardVO vo) {
		log.info(" ---게시판 글쓰기 처리 ----");
		log.info(vo);
		// 게시판 리스트로 보낸다.
		return "redirect:list.do";
	}

	// 게시판 글 수정 폼
	@GetMapping("/update.do")
	public String updateForm() {
		log.info(" ---게시판 글수정 폼 ----");
		// /WEB-INF/views +board + / + update + .jsp
		return MODULE + "/" + "update";
	}

	// 게시판 글 수정 처리
	@PostMapping("/update.do")
	public String update() {
		log.info(" ---게시판 글수정 처리 ----");
		//글보기로 자동이동
		return "redirect:view.do";
	}

	// 게시판 글삭제
	@PostMapping("/delete.do")
	public String delect() {
		log.info(" ---게시판 글삭제 ----");
		//글 리스트로 자동 이동
		return "redirect:list.do";
	}
	
	//게시판 글 삭제 폼 - 여러개의 글번호가 넘오어는 경우
	@GetMapping("/deleteArray.do")
	public String delectArrayForm() {
		log.info(" ---게시판 글삭제 ----");
		//글 리스트로 자동 이동
		return MODULE + "/" + "deleteArrayForm";
	}

	@PostMapping("/deleteArray.do")
	public String delectArray(@RequestParam(name="no") Long[] no, Model model ) {
		log.info(" ---게시판 글삭제 처리 여러개의 데이터 ----");
		//실제적으로 삭제 할 때 2가지 방법
		//1.for문을 이용해서 service에서 삭제 매서드를 여러번 호출
		//2.delete board where no in(삭제들 번호들);
		log.info(Arrays.toString(no));
		model.addAttribute("no",no);
		//글 리스트로 자동 이동
		return MODULE + "/" + "deleteArray";
	}
	


}
