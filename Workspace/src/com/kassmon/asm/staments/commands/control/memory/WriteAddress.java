package com.kassmon.asm.staments.commands.control.memory;

import com.kassmon.asm.staments.commands.CommandStatment;

public class WriteAddress extends CommandStatment {
	
	private int value;
	
	public WriteAddress(int lineNumber, int value) {
		super(lineNumber, true);
		this.value = value;
	}

	@Override
	public void execute() {
		registers.setAddressRegister(value);
	}

	@Override
	public String toString() {
		//TODO: add a proper toString method
		return null;
	}

}
