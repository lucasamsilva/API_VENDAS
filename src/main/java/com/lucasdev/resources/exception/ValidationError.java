package com.lucasdev.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

	private static final long serialVersionUID = 1L;
	private List<FieldMessage> errors = new ArrayList<FieldMessage>();

	public ValidationError(Long timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}
	
	public void addError(String fieldname, String mensagem) {
		errors.add(new FieldMessage(fieldname, mensagem));
	}
	
}
