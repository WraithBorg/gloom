package com.cthulhu.common;

public class ServiceResult<T> {
	private T data;
	private boolean result;
	private String message = "success";

	/********************************************** Constructor ****************************************/
	public ServiceResult(boolean result) {
		this.result = result;
	}

	public ServiceResult(boolean result, T data) {
		this.data = data;
		this.result = result;
	}

	public ServiceResult(boolean result, T data, String message) {
		this.data = data;
		this.result = result;
		this.message = message;
	}

	/********************************************** Getter ********************************************/
	public T getData() {
		return data;
	}

	public boolean isResult() {
		return result;
	}

	public String getMessage() {
		return message;
	}

	/********************************************** Setter ********************************************/
	public void setData(T data) {
		this.data = data;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
