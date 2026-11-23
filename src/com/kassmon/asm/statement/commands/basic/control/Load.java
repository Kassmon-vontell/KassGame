package com.kassmon.asm.statement.commands.basic.control;

import com.kassmon.asm.exceptions.MemoryOutOfBoundsException;
import com.kassmon.asm.exceptions.ScriptException;
import com.kassmon.asm.statement.arguments.Argument;
import com.kassmon.asm.statement.commands.CommandStatment;

public class Load extends CommandStatment {
	
	private Argument value, memAddress;
	
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
		//TODO: implement toString
		return null;
	}

}
