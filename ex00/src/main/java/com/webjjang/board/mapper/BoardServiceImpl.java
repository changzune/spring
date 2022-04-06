package com.webjjang.board.mapper;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import com.webjjang.board.vo.BoardVO;


//자동으로 생성이 되게 하는 어노테이션
//@Controller - url과 관련, @Service - 처리,  @Repository - DAO, @Component - 구성, @RestController - url과 관련 순수데이터
@Service
public class BoardServiceImpl {
	
	// 자동 DI를 적용시키는 어노테이션
		// @Inject - java, @Autowired - Spring, @Setter - Lombok
		@Inject
		private BoardMapper mapper;
		
		// 게시판 리스트
		public List<BoardVO> list(){
			return mapper.list();
		}
		
		// 게시판 글보기
		public BoardVO view(Long no, int inc) {
			if(inc == 1) mapper.increase(no);
			return mapper.view(no);
		}
		
		// 게시판 글쓰기
		public int write(BoardVO vo) {
			return mapper.write(vo);
		}
		
		// 게시판 글수정
		public int update(BoardVO vo) {
			return mapper.update(vo);
		}
		
		// 게시판 글삭제
		public int delete(Long no) {
			return mapper.delete(no);
		}

}
