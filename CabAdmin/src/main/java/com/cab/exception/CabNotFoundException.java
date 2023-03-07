package com.cab.exception;

public class CabNotFoundException extends RuntimeException {

	 private static final long serialVersionUID = 1L;
	 
	 public CabNotFoundException(String msg) {
		 super(msg);
		 
	 }
}