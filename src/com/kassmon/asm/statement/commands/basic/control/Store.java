package com.kassmon.asm.statement.commands.basic.control;

import com.kassmon.asm.exceptions.MemoryOutOfBoundsException;
import com.kassmon.asm.exceptions.ScriptException;
import com.kassmon.asm.statement.arguments.Argument;
import com.kassmon.asm.statement.arguments.ArgumentType;
import com.kassmon.asm.statement.commands.CommandStatment;

public class Store extends CommandStatment {
	
	private Argument register, memAddress;
	
	public Store(int lineNumber, Argument register, Argument memAddress) {
		super(lineNumber, true);
		this.register = register;
		this.memAddress = memAddress;
	}

	@Override
	public void execute() {
		if (register.getType() != ArgumentType.REGISTER) 
			throw new ScriptException("First argument must be a register");
		int registerAddress = getValueFromArgument(register);
		int value = memory.read(getValueFromArgument(memAddress));
		try {
			registers.write(registerAddress, value);
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
