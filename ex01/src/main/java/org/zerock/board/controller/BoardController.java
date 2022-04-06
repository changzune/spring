package org.zerock.board.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.board.mapper.BoardServiceImpl;
import org.zerock.board.vo.BoardVO;

import lombok.extern.log4j.Log4j;

//자동으로 생성이 되게 하는 어노테이션
//@Controller - url과 관련, @Service - 처리,  @Repository - DAO, @Component - 구성, @RestController - url과 관련 순수데이터
@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {

	// 자동 DI를 적용시키는 어노테이션
	// @Inject - java, @Autowired - Spring, @Setter - Lombok
	@Autowired
	private BoardServiceImpl boardServiceImpl;
	
	private final String MODULE = "board";
	
	// url별 메서드 작성
	
	// 게시판 리스트
	@GetMapping("/list.do")
	public String list(Model model) {
		log.info("--[게시판 리스트]-----------------------------------");
		
		model.addAttribute("list", boardServiceImpl.list());
		
		// /WEB-INF/views  + board + / + list + .jsp
		return MODULE + "/" + "list";
	}
	
	// 게시판 글보기
	@GetMapping("/view.do")
	// 글번호가 필요하다. request에서 꺼내는 방식(예전), 지금은 spring의 DispacherServlet이 자동으로 매칭되는 것을 꺼내서 전달해 준다.
	// 처리된 데이터(DB 가져오는 데이터 : 강제)는 Model에 담으면 되는데 Model을 파라메터로 받는다.
	// no : Long type인 경우는 데이터가 넘어오지 않더라도 null이 가능해서 오류가 나지 않는다.
	//      그런데 기본형 타입인 long인 경우 - String 데이터를 받아서 Long.parseLong(String) Number 타입이 아니고 null을 저장할 수
	//      없어서 오류가 난다. -> 꼭 필요한 데이터는 오류를 내고 오류 처리를 해 주세요.
	public String view(long no, @RequestParam(defaultValue = "0") int inc, Model model) {
		log.info("--[게시판 글보기]-----------------------------------");
		log.info("글번호 : " + no + ", 증가:" + inc);
		
		BoardVO vo = boardServiceImpl.view(no, inc);
		// 줄바꿈 문자를 <br> 태그로 바꾸는 처리를 한다.
		vo.setContent(vo.getContent().replaceAll("\n", "<br>"));
		
		// JSP에 전달하기 위해서 model에 데이터는 저장해 놓는다.
		model.addAttribute("vo", vo);
		
		// /WEB-INF/views  + board + / + view + .jsp
		return MODULE + "/" + "view";
	}
	
	// 게시판 글쓰기 폼
	@GetMapping("/write.do")
	public String writeForm() {
		log.info("--[게시판 글쓰기 폼]-----------------------------------");
		// /WEB-INF/views  + board + / + write + .jsp
		return MODULE + "/" + "write";
	}
	
	// 게시판 글쓰기 처리
	@PostMapping("/write.do")
	public String write(BoardVO vo, RedirectAttributes rttr) {
		log.info("--[게시판 글쓰기 처리]-----------------------------------");
		log.info(vo);
		
		boardServiceImpl.write(vo);
		
		// 딱 한번만 사용이되는 데이터 저장
		rttr.addFlashAttribute("msg", "게시판 글등록이 되셨습니다.");
		// 게시판 리스트로 보낸다.
		return "redirect:list.do";
	}
	
	// 게시판 글수정 폼
	@GetMapping("/update.do")
	public String updateForm(Long no, Model model) {
		log.info("--[게시판 글수정 폼]-----------------------------------");
		
		// 수정할 데이터를 가져온다. view
		model.addAttribute("vo", boardServiceImpl.view(no, 0));		
		// /WEB-INF/views  + board + / + update + .jsp
		return MODULE + "/" + "update";
	}
	
	// 게시판 글 수정 처리
	@PostMapping("/update.do")
	public String update(BoardVO vo, RedirectAttributes rttr) {
		log.info("--[게시판 글수정 처리]-----------------------------------");
		
		int result = boardServiceImpl.update(vo);
		log.info("수정 결과 result : " + result);
		
		// 딱 한번만 사용이되는 데이터 저장
		rttr.addFlashAttribute("msg", "게시판 글수정이 되셨습니다.");
		
		// 글보기로 자동으로 이동
		return "redirect:view.do?no=" + vo.getNo();
	}
	
	// 게시판 글삭제 - 비밀번호 적용 안함.
	@GetMapping("/delete.do")
	public String delete(Long no, RedirectAttributes rttr) {
		log.info("--[게시판 글삭제]-----------------------------------");
		
		boardServiceImpl.delete(no);
		
		// 딱 한번만 사용이되는 데이터 저장
		rttr.addFlashAttribute("msg", "게시판 글이 삭제 되었습니다.");
		
		// 글리스트로 자동 이동
		return "redirect:list.do";
	}
	
	// 게시판 글삭제 폼 - 여러개의 글번호가 넘어오는 경우
	@GetMapping("/deleteArray.do")
	public String deleteArrayForm() {
		log.info("--[게시판 글삭제 폼 - 여러개]-----------------------------------");
		// 글리스트로 자동 이동
		return MODULE + "/" + "deleteArrayForm";
	}
	
	// 게시판 글삭제 - 여러개의 글번호가 넘어오는 경우
	// @ModelAttribute("no") - 데이터를 그대로 담아서 JSP까지 전달해 준다. - 배열로 받을 때는 사용하면 안된다.
	// no 변수 한개로 받을 때는 여러개의 no를 넘겨도 오류는 나지 않지만 맨앞에 있는 데이터만 받는다. 나머지는 무시된다.
	@PostMapping("/deleteArray.do")
	public String deleteArray(@RequestParam(name="no") Long[] nos, Model model) {
		log.info("--[게시판 글삭제 처리 - 여러개의 데이터]-----------------------------------");
		// 실제적으로 삭제할 때 2가지 방법
		// 1. for 문을 이용해서 service에서 삭제 메서드를 여러번 호출 - JAVA 단에서 해결
		// 2. delete board where no in(삭제할 번호들); - DB 단에서 해결
		log.info(Arrays.toString(nos));
		model.addAttribute("nos",nos);
		// 글리스트로 자동 이동
		return MODULE + "/" + "deleteArray";
	}
	
}
