package com.enesbayram.exception.handler;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Exception<E>{

	private Date createTime;
	
	private String path;
	
	private String hostName;
	
	private E message;
	
	
}
