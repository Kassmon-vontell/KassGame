package com.kassmon.asm.staments.commands.basic.conditionals;

import com.kassmon.asm.staments.commands.CommandStatment;

public class JumpNotEqual extends CommandStatment {
	
	private String label;
	
	public JumpNotEqual(int lineNumber, String label) {
		super(lineNumber, false);
	}

	@Override
	public void execute() {
		if(!registers.isEqual()) 
			status.setProgramCounter(labelPointers.getLabelPointer(label));
	}

	@Override
	public String toString() {
		//TODO: add toString method
		return null;
	}

}
