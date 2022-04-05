package com.webjjang.image.controller;

import java.net.http.HttpClient.Redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/image")
@Log4j
public class imageController {
	
	@GetMapping("/list")
	public void list() {
		log.info("--------------[이미지게시판]--------");
		
	}
	
	@GetMapping("/write")
	public void writeForm() {
		log.info("--------------[이미지게시판 등록]--------");
		
	}
	
	@PostMapping("/write")
	public String write() {
		log.info("--------------[이미지게시판]--------");
		
		return "redirect:list";
		
		
	}
	
	

}
