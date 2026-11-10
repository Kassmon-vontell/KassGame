package com.kassmon.asm.staments.commands.control.memory;

import com.kassmon.asm.staments.commands.CommandStatment;

public class StoreMemory extends CommandStatment {
	
	private int registerPointer;
	
	public StoreMemory(int lineNumber, int registerPointer) {
		super(lineNumber, true);
		this.registerPointer = registerPointer;
	}

	@Override
	public void execute() {
		registers.write(registerPointer, pluginManager.read());
	}

	@Override
	public String toString() {
		//TODO: add a proper toString method
		return null;
	}

}
