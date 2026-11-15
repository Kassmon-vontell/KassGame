package com.kassmon.asm.runtime.data;

public class Status {
	
	private int programCounter;
	private StatusCodes statusCode;
	
	public Status() {
		this.programCounter = 0;
		this.statusCode = StatusCodes.PRESTART;
	}
	
	public int getProgramCounter() {
		return programCounter;
	}
	
	public void setProgramCounter(int programCounter) {
		this.programCounter = programCounter;
	}
	
	public StatusCodes getStatusCode() {
		return statusCode;
	}
	
	public void setStatusCode(StatusCodes statusCode) {
		this.statusCode = statusCode;
	}
	
	
	
	
}
