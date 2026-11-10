package com.kassmon.asm.staments.commands.control.register;

import com.kassmon.asm.staments.commands.CommandStatment;

public class LoadRegister extends CommandStatment {
	
	public int value, registerPointer;
	
	public LoadRegister(int lineNumber, int value, int registerPointer) {
		super(lineNumber, true);
		this.value = value;
		this.registerPointer = registerPointer;
	}
	
	@Override
	public void execute() {
		this.registers.write(registerPointer, value);
	}

	@Override
	public String toString() {
		//TODO: add a proper toString method
		return null;
	}

}
