package com.kassmon.asm.statement.commands.basic.control;

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
		registers.write(registerAddress, value);
	}

	@Override
	public String toString() {
		//TODO: implement toString
		return null;
	}

}
