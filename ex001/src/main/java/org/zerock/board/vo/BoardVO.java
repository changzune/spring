package org.zerock.board.vo;

import java.util.Date;

import lombok.Data;

//getter setter toSting 지원 lombok 기능
@Data
public class BoardVO {

	private Long no;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	private Long hit;

	
}
