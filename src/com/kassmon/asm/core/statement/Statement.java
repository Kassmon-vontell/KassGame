package com.kassmon.asm.core.statement;

public abstract class Statement{
	
	protected final int lineNumber;
	
	public Statement(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	
	
	public int getLineNumber() {
		return lineNumber;
	}
	
	public abstract String toString();
	
}
