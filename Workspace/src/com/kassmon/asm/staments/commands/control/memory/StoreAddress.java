package com.kassmon.asm.staments.commands.control.memory;

import com.kassmon.asm.staments.commands.CommandStatment;

public class StoreAddress extends CommandStatment {
	
	int registerPointer;
	
	public StoreAddress(int lineNumber, boolean advanceProgramCounter, int registerPointer) {
		super(lineNumber, true);
		this.registerPointer = registerPointer;
	}

	@Override
	public void execute() {
		registers.write(registerPointer, registers.getAddressRegister());
	}

	@Override
	public String toString() {
		//TODO: add a proper toString method
		return null;
	}

	

}
