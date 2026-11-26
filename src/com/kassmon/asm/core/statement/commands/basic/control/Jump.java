package com.kassmon.asm.core.statement.commands.basic.control;

import com.kassmon.asm.core.statement.commands.CommandStatement;

public class Jump extends CommandStatement{
	
	private final String label;
	
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
		return "jump " + label;
	}

}
