package com.kassmon.asm.statement.commands.basic.control;

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
		memory.write(getValueFromArgument(memAddress), getValueFromArgument(value));
	}

	@Override
	public String toString() {
		//TODO: implement toString
		return null;
	}

}
