package com.kassmon.asm.staments.commands.control.memory;

import com.kassmon.asm.staments.commands.CommandStatment;

public class LoadAddress extends CommandStatment {
	
	public int registerPointer;
	
	public LoadAddress(int lineNumber, int registerPointer) {
		super(lineNumber, true);
		this.registerPointer = registerPointer;
	}

	@Override
	public void execute() {
		registers.setAddressRegister(registers.read(registerPointer));
	}

	@Override
	public String toString() {
		//TODO: add a proper toString method
		return null;
	}

}
