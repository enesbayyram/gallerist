package com.enesbayram.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "create_time")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date createTime;
	
	@Column(name = "last_modified_time")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date lastModifiedTime;
	
}
