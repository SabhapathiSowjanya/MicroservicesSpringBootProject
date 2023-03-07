package com.cab.exception;

public class ErrorDetails {
	private String errorMessage;
	private int errorCode;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	@Override
	public String toString() {
		return "ErrorDetails [errorMessage=" + errorMessage + ", errorCode=" + errorCode + "]";
	}
	public ErrorDetails(String errorMessage, int errorCode) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}
	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
}

