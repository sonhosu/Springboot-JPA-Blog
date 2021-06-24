package com.cos.blog.Test;

import java.util.List;
import java.util.function.Supplier;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {

	@Autowired
	private UserRepository userRepository;
	
	//save 함수는 id를 전달하지않으면 insert해주고
	//save 함수는 id를 전달하면 해당id에 대한 데이터가 있으면 update
	//save 함수는 id를 전달하면 해당id에 대한 데이터가 없으면 insert
	//email, password
	
	
	//삭제
	@DeleteMapping("/dummy/user/{id}")
	public String delet(@PathVariable int id) {	
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			return "삭제에 실패함";			
		}
		
		return "삭제완료 id:"+id;
	}
	
	
	//수정
	@Transactional
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id,@RequestBody User requestUser) {
		
		System.out.println("id:"+id);
		System.out.println("password:"+requestUser.getPassword());
		System.out.println("email:"+requestUser.getEmail());
		
		User user = userRepository.findById(id).orElseThrow(()->{
			return new  IllegalArgumentException("수정에 실패했습니다.");
		});
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
		
		
		userRepository.save(user);
		
		//더티체킹
		return user;
	}
	
	//http://localhost:8000/blog/dummy/user
	@GetMapping("/dummy/users")
	public List<User> list(){
		
		return userRepository.findAll();
	}
	
	//paging 하는방법
	//한페이지당 2개의 데이터를 리턴받아볼 예정
	@GetMapping("/dummy/user")
	public List<User> pageList(@PageableDefault(size =2, sort="id",direction = Sort.Direction.DESC) Pageable pageable){
		Page<User> pagingUser =userRepository.findAll(pageable);
		
		if(pagingUser.isFirst()) {
			
		}
		List<User> users = pagingUser.getContent();
		return users;
	}
	
	//{id} 주소로 파라미터를 전달받을수 있음.
	//http://localhost:8000/blog/dummy/user/3
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {

			@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return new IllegalArgumentException("해당 유저는 없습니다.id:"+id);
		
			}
		} );
		//요청:웹브라우저
		//USER 객체 = 자바 오브젝트
		//변환 (웹브라우저가 이해할수있는 데이터) ->JSON
		
		return user;
	}
	
	//http://localhost:8000/blog/dummy/join
	@PostMapping("/dummy/join")
	public String join(User user) {
		System.out.println("id:"+user.getId());
		System.out.println("username:"+user.getUsername());
		System.out.println("password:"+user.getPassword());
		System.out.println("email:"+user.getEmail());
		System.out.println("role:"+user.getRole());
		System.out.println("createDate:"+user.getCreateDate());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입 완료";
	}
}
