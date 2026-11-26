package com.kassmon.asm.core.statement.commands.basic.control;

import com.kassmon.asm.exceptions.MemoryOutOfBoundsException;
import com.kassmon.asm.exceptions.ScriptException;
import com.kassmon.asm.core.statement.arguments.Argument;
import com.kassmon.asm.core.statement.commands.CommandStatement;

public class Load extends CommandStatement{
	
	private final Argument value, memAddress;
	
	public Load(int lineNumber, Argument value, Argument memAddress) {
		super(lineNumber, true);
		this.value = value;
		this.memAddress = memAddress;
	}

	@Override
	public void execute() {
		try {
			memory.write(getValueFromArgument(memAddress), getValueFromArgument(value));
		} catch (MemoryOutOfBoundsException e) {
			throw new ScriptException("Memory out of bounds on line: " + lineNumber, e);
		}
	}

	@Override
	public String toString() {
		return "load " + value.toString() + " " + memAddress.toString();
	}

}
