package com.cos.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;


//스프링이 컴포넌트 스캔을통해서 Bean에 등록 해줌
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Transactional
	public void 회원가입(User user) {
		userRepository.save(user);
	}
	@Transactional
	public void 로그인(User user) {
		userRepository.save(user);
	}
	
}
