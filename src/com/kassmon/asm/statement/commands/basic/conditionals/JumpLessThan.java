package com.kassmon.asm.statement.commands.basic.conditionals;

import com.kassmon.asm.statement.commands.CommandStatment;

public class JumpLessThan extends CommandStatment {
	
	private String label;
	
	public JumpLessThan(int lineNumber, String label) {
		super(lineNumber, false);
		this.label = label;
	}

	@Override
	public void execute() {
		if(registers.isLess()) 
			registers.setProgramCounter(labelPointers.getLabelPointer(label));
	}

	@Override
	public String toString() {
		//TODO: add toString method
		return null;
	}

}
