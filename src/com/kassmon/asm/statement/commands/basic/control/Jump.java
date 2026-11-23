package com.kassmon.asm.statement.commands.basic.control;

import com.kassmon.asm.statement.commands.CommandStatment;

public class Jump extends CommandStatment {
	
	private String label;
	
	public Jump(int lineNumber, String label) {
		super(lineNumber, false);
		this.label = label;
	}

	@Override
	public void execute() {
		registers.setProgramCounter(labelPointers.getLabelPointer(label));
	}

	@Override
	public String toString() {
		//TODO: add toString method
		return null;
	}

}
