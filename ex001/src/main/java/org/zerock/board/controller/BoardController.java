package org.zerock.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.board.vo.BoardVO;

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
	@GetMapping("/view.do")
	//글번호가 필요하다. request에서 꺼내는 방식이(예전), 지금은 spring의 dispacherServlet이
	//자동으로 매칭되는 것을 꺼내서 전달해준다.
	//처리된 데이터(DB 가져오는 데이터 : 강제로 만든다.) Model에 담으면 되는데 Model을 파라메터를받는다.
	// no : long type인 경우는 데이터가 넘어오지 않더라도 null이 가능해서 오류가 나지않는다.
	// 그런데 기본형 타입인 long 경우 - String 데이터를 받아서 Long.parseLong(String) Number 타입이 아니고 null을 저장할 수없어서
	// 없어서 오류가 난다. -> 꼭필요한 데이터는 오류를 내고 오류처리를 해주세요.
	
	public String view(long no, @RequestParam(defaultValue = "0") int inc, @ModelAttribute Long page, Model model) {
		log.info("----[게시판 글보기]-------------------------");
		log.info("글번호 :" + no + ", 증가 : " + inc );
		
		BoardVO vo = new BoardVO();
		vo.setNo(10L);
		vo.setTitle("test");
		vo.setContent("test test");
		vo.setWriter("lee");
		vo.setWriter("lee");
		
		//jsp까지 전달하기 위해서 model에 데이터는 저장해 놓는다.
		model.addAttribute("vo", vo);
		
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
	public String write(BoardVO vo) {
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
		return "redirect:viwe.do";
	}
	
	//게시판 글 삭제
	@PostMapping("/delete.do")
	public String delete() {
		log.info("----[게시판 글 삭제]-------------------------");
		// 글 리스토로 자동이동
		return "redirect:list.do";
	}
	

	

}
