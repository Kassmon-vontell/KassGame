package com.kassmon.asm.staments.commands.basic.control.memory;

import com.kassmon.asm.staments.commands.CommandStatment;

public class StoreAddress extends CommandStatment {
	
	int registerPointer;
	
	public StoreAddress(int lineNumber, int registerPointer) {
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
