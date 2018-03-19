package com.save.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class NotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	
	//identifiant de l'objet recherché
	private Long id;
	
	public NotFoundException(String message, Long id) {
		super(message);
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

}
