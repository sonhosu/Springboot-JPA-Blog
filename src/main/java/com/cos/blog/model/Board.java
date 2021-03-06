package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
	private int id;
	
	@Column(nullable = false ,length = 100)
	private String title;
	
	@Lob//대용량 데이터
	@Column(nullable = false, length = 200)
	private String content;//섬머노트 라이브러리<html>태그가 섞여서 디자인이됨.
	
	
	private int count;//조회수
	
	@ManyToOne(fetch = FetchType.EAGER)// Many = Board , User = one
	@JoinColumn(name="userid")
	private User user;//DB는 오브젝트를 저장 x FK, java는 오브젝트를 저장할수있다.
	
	@OneToMany(mappedBy = "board",fetch = FetchType.LAZY)// mappedBy 연관관계의 주인이 아님 (난 Fk가 아니에요)
	private List<Reply> reply;
	
	@CreationTimestamp
	private Timestamp createDate;
	
	
}
