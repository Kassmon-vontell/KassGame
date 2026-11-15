package com.kassmon.asm.staments.commands.basic.control.programCounter;

import com.kassmon.asm.staments.commands.CommandStatment;

public class Jmp extends CommandStatment {
	
	private String label;
	
	public Jmp(int lineNumber, String label) {
		super(lineNumber, false);
		this.label = label;
	}

	@Override
	public void execute() {
		status.setProgramCounter(labelPointers.getLabelPointer(label));
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
