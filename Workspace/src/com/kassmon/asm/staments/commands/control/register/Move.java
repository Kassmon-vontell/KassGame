package com.kassmon.asm.staments.commands.control.register;

import com.kassmon.asm.staments.commands.CommandStatment;

public class Move extends CommandStatment {

	private int sourceRegisterPointer, destinationRegisterPointer;
	
	public Move(int lineNumber, boolean advanceProgramCounter, int sourceRegisterPointer, int destinationRegisterPointer) {
		super(lineNumber, advanceProgramCounter);
		this.sourceRegisterPointer = sourceRegisterPointer;
		this.destinationRegisterPointer = destinationRegisterPointer;
	}

	@Override
	public void execute() {
		registers.write(destinationRegisterPointer, registers.read(sourceRegisterPointer));
	}

	@Override
	public String toString() {
		//TODO: add a proper toString method
		return null;
	}

}
