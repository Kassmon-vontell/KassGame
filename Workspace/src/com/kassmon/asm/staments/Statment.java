package com.kassmon.asm.staments;

public abstract class Statment {
	
	protected final int lineNumber;
	
	public Statment(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	
	
	public int getLineNumber() {
		return lineNumber;
	}
	
	public abstract String toString();
	
}
