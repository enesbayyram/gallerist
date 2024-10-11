package com.enesbayram.exception.handler;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.enesbayram.exception.BaseException;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(value = {BaseException.class})
	public  ResponseEntity<ApiError<?>> handleBaseException(BaseException ex , WebRequest request) {
		return ResponseEntity.badRequest().body(createApiError(ex.getMessage(), request));
	}
	
	public List<String> add(List<String> list , String newValue){
		list.add(newValue);
		
		return list;
	}

	@ExceptionHandler(value = {MethodArgumentNotValidException.class})
	public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex , WebRequest request) {
		Map<String, List<String>> map = new HashMap<>();
		
		List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
		for (ObjectError objectError : allErrors) {
			String fieldName = ((FieldError)objectError).getField();
			if(map.containsKey(fieldName)) {
				map.put(fieldName, add(map.get(fieldName), objectError.getDefaultMessage()));
			}else {
				map.put(fieldName, add(new ArrayList<>(), objectError.getDefaultMessage()));
			}
		}
		
		return ResponseEntity.badRequest().body(createApiError(map, request));
	}
	
	
	public String getHostName() {
		try {
			return Inet4Address.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		}
		return "";
	}
	
	public <E> ApiError<E> createApiError(E message , WebRequest request){
		ApiError<E> apiError = new ApiError<>();
		apiError.setStatus(HttpStatus.OK.value());
		
		Exception<E> exception = new Exception<>();
		exception.setCreateTime(new Date());
		exception.setHostName(getHostName());
		exception.setMessage(message);
		exception.setPath(request.getDescription(false).substring(4));
		
		apiError.setException(exception);
		
		return apiError;
	}
}
