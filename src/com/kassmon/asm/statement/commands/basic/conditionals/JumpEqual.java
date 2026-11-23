package com.kassmon.asm.statement.commands.basic.conditionals;

import com.kassmon.asm.statement.commands.CommandStatment;

public class JumpEqual extends CommandStatment {
	
	private String label;
	
	public JumpEqual(int lineNumber, String label) {
		super(lineNumber, false);
		this.label = label;
	}

	@Override
	public void execute() {
		if(registers.isEqual()) 
			registers.setProgramCounter(labelPointers.getLabelPointer(label));
	}

	@Override
	public String toString() {
		//TODO: add toString method
		return null;
	}

}
