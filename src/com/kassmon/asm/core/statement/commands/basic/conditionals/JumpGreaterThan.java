package com.kassmon.asm.core.statement.commands.basic.conditionals;

import com.kassmon.asm.core.statement.commands.CommandStatement;

public class JumpGreaterThan extends CommandStatement{
	
	private final String label;
	
	public JumpGreaterThan(int lineNumber, String label) {
		super(lineNumber, false);
		this.label = label;
	}

	@Override
	public void execute() {
		if(registers.isGreater()) 
			registers.setProgramCounter(labelPointers.getLabelPointer(label));
	}

	@Override
	public String toString() {
		return "jump " + label;
	}

}
