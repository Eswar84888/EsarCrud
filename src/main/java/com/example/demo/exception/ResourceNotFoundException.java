package com.example.demo.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1l;
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
	public ResourceNotFoundException(String msg,Throwable throwable) {
		super(msg,throwable);
	}
}
