package com.kassmon.asm.staments.info;

import com.kassmon.asm.staments.Statment;

public class Label extends Statment {
	
	private String label;
	
	public Label(int lineNumber, String label) {
		super(lineNumber);
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
	@Override
	public String toString() {
		return "label: " + label.toString();
	}
	
}
