package com.ty.wellness_care.exceptionhandler;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.wellness_care.exception.IDNotFoundException;
import com.ty.wellness_care.util.ResponseStructure;
import static com.ty.wellness_care.util.Messages.*;

@ControllerAdvice
public class FieldValidationExceptionHandler extends ResponseEntityExceptionHandler  {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> info=new LinkedHashMap<String, String>();
		List<ObjectError> errors=ex.getAllErrors();
		for(ObjectError error:errors) {
			String fieldName=((FieldError)error).getField();
			String message=error.getDefaultMessage();
			info.put(fieldName, message);
		}
		ResponseStructure<Map<String, String>> responseStructure=new ResponseStructure<Map<String,String>>();
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setMessage(VALIDATION_ERROR);
        responseStructure.setData(info);		
		
		return new ResponseEntity<Object>(responseStructure, HttpStatus.BAD_REQUEST) ;
	}
	
	@ExceptionHandler(IDNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> userNotFoundExceptionHandler(IDNotFoundException exception){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setData("Exception: ID Not Found");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	
	
}
