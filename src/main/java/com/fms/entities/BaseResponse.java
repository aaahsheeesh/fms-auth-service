package com.fms.entities;

public class BaseResponse<T> {

	private boolean status;
	private String message;
	private T data;

	public BaseResponse() {
		super();
	}
	
	public BaseResponse(boolean status, String message, T data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getErrorMsg() {
		return message;
	}

	public void setErrorMsg(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
