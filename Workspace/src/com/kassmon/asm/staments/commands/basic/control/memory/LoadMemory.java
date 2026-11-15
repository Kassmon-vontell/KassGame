package com.kassmon.asm.staments.commands.basic.control.memory;

import com.kassmon.asm.staments.commands.CommandStatment;

public class LoadMemory extends CommandStatment {
	
	private int registerPointer;
	
	public LoadMemory(int lineNumber, int registerPointer) {
		super(lineNumber, true);
		this.registerPointer = registerPointer;
	}

	@Override
	public void execute() {
		this.pluginManager.write(registers.read(registerPointer));
	}

	@Override
	public String toString() {
		//TODO: add toString implementation
		return null;
	}

	

}
