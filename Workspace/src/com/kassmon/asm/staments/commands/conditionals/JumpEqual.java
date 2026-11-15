package com.kassmon.asm.staments.commands.conditionals;

import com.kassmon.asm.staments.commands.CommandStatment;

public class JumpEqual extends CommandStatment {
	
	private String label;
	
	public JumpEqual(int lineNumber, String label) {
		super(lineNumber, false);
		this.label = label;
	}

	@Override
	public void execute() {
		if(registers.isEqual()) 
			status.setProgramCounter(labelPointers.getLabelPointer(label));
	}

	@Override
	public String toString() {
		//TODO: add toString method
		return null;
	}

}
