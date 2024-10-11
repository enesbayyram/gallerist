package com.enesbayram.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(value = Include.NON_NULL)
public class RootEntity <T>{

	private Integer status;
	
	private T payload;
	
	private String errorMessage;
	
	
	public static <T> RootEntity<T> build(Integer status , T payload , String errorMessage){
		RootEntity<T> rootEntity = new RootEntity<>();
		rootEntity.setStatus(status);
		rootEntity.setPayload(payload);
		rootEntity.setErrorMessage(errorMessage);
		return rootEntity;
	}
	
	public static <T> RootEntity<T> ok(T payload){
		return build(200, payload, null);
	}
	
	public static <T> RootEntity<T> error(String errorMessage){
		return build(500, null, errorMessage);
	}
}
