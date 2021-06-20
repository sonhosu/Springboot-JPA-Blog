package com.cos.blog.model;

import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder//빌더패턴!!
//ORM ? Java Object -> 테이블로 매핑해주는 기술
@Entity//User 클래스가 MySQL에 테이블이 생성됨


public class User {

	@Id//Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링전략을 따라감
	private int id;//시퀀스
	
	@Column(nullable=false, length= 30)
	private String username;//아이디
	
	@Column(nullable=false, length= 100)//12345 ->해쉬로 변경해서 암호화
	private String password;
	
	@Column(nullable=false, length= 50)
	private String eamil;
	
	@ColumnDefault("'user'")
	private String role;//Enum을 쓰는게 좋다. //admin,user,manager
	
	@CreationTimestamp// 시간 자동입력
	private Timestamp createDate;
}
