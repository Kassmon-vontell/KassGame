package com.kassmon.asm.staments.commands.basic.control.memory;

import com.kassmon.asm.staments.commands.CommandStatment;

public class WriteMemory extends CommandStatment {
	
	public int value;
	
	public WriteMemory(int lineNumber, int value) {
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
