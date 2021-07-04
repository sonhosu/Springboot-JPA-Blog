package com.cos.blog.service;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.Board;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.BoardRepository;
import com.cos.blog.repository.UserRepository;




//스프링이 컴포넌트 스캔을통해서 Bean에 등록 해줌
@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	

	
	
	@Transactional
	public void 글쓰기(Board board , User user) { // title, content
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
		
	}	
	public List<Board> 글목록(){
		return boardRepository.findAll();
	}
	
}
