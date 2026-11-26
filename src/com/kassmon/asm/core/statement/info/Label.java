package com.kassmon.asm.core.statement.info;

import com.kassmon.asm.core.statement.Statement;

public class Label extends Statement{
	
	private final String label;
	
	public Label(int lineNumber, String label) {
		super(lineNumber);
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
	@Override
	public String toString() {
		return ":" + label;
	}
	
}