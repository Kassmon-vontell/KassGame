package com.kassmon.asm.staments.commands.basic.conditionals;

import com.kassmon.asm.staments.commands.CommandStatment;

public class JumpLessThan extends CommandStatment {
	
	private String label;
	
	public JumpLessThan(int lineNumber, String label) {
		super(lineNumber, false);
		this.label = label;
	}

	@Override
	public void execute() {
		if(registers.isLess()) 
			status.setProgramCounter(labelPointers.getLabelPointer(label));
	}

	@Override
	public String toString() {
		//TODO: add toString method
		return null;
	}

}
