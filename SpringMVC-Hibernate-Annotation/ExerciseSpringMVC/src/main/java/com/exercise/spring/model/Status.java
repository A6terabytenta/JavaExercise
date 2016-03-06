package com.exercise.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Status {
	private String errorCore;
	private String errorMessage;
	private String status;
	public static final String SUCCESSFUL = "True";
	public static final String FAIL = "False";
	public static final String STATUSSUCCESSFUL = "Successful";
	public static final String STATUSFAIL = "Fail";

	public Status() {
		super();
	}

	public Status(String errorCore, String errorMessage, String status) {
		super();
		this.errorCore = errorCore;
		this.errorMessage = errorMessage;
		this.status = status;
	}

	public String getErrorCore() {
		return errorCore;
	}

	public void setErrorCore(String errorCore) {
		this.errorCore = errorCore;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Status [errorCore=" + errorCore + ", errorMessage="
				+ errorMessage + ", status=" + status + "]";
	}
}
