package com.jpabasic;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@SequenceGenerator( 
		 name = "MEMBER_SEQ_GENERATOR", 
		 sequenceName = "MEMBER_SEQ", //매핑할 데이터베이스 시퀀스 이름
		 initialValue = 1, allocationSize = 50) 
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
	 		generator = "MEMBER_SEQ_GENERATOR")
	private Long id;

	@Column(name = "name", nullable = false)
	private String username;
//
//	private int age;
//
//	@Enumerated(EnumType.STRING)
//	private RoleType roleType;
//
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date createdDate;
//
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date lastModifiedDate;
//	
//	private LocalDate testLocalDate;
//	
//	private LocalDateTime testLocalDateTime;
//
//	@Lob
//	private String description;
//
//	@Transient
//	private int temp;

	public Member() {
	}

	public Member(Long id, String username) {
		this.id = id;
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
