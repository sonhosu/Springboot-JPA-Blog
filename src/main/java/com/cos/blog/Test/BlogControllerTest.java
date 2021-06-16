package com.cos.blog.Test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//스프링이 com.cos.blog패키지 이하를 스캔해서 모든파일을  메모리에 new하는것은 아님
//특정 어노테이션이 붙어있는 클래스 파일들을 new해서 스프링컨테이너에 관리

@RestController
public class BlogControllerTest {
	
	//http://localhost:8090/test/hello
		@GetMapping("/test/hello")
	public String hello() {
		return "<h1>hello spring boot</h1>" ;
	}
}
