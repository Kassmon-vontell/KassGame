package com.kassmon.asm.staments.commands.control.memory;

import com.kassmon.asm.staments.commands.CommandStatment;

public class WriteMemory extends CommandStatment {
	
	public int value;
	
	public WriteMemory(int lineNumber, int value, int memoryPointer) {
		super(lineNumber, true);
		this.value = value;
	}
	
	@Override
	public void execute() {
		pluginManager.write(value);
	}

	@Override
	public String toString() {
		//TODO: add a proper toString method
		return null;
	}

	

}
