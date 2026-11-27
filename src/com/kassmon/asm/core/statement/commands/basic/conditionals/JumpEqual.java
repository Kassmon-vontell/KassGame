package com.kassmon.asm.core.statement.commands.basic.conditionals;

import com.kassmon.asm.core.statement.commands.CommandStatement;

public class JumpEqual extends CommandStatement{
	
	private final String label;
	
	public JumpEqual(int lineNumber, String label) {
		super(lineNumber, false);
		this.label = label;
	}

	@Override
	public void execute() {
		if(registers.isEqual()){
			registers.setProgramCounter(labelPointers.getLabelPointer(label));
			advanceProgramCounter = false;
			return;
		}
		advanceProgramCounter = true;
	}

	@Override
	public String toString() {
		return "jump " + label;
	}

}
