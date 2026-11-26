package com.kassmon.asm.core.statement.commands.basic.control;

import com.kassmon.asm.core.statement.arguments.Argument;
import com.kassmon.asm.core.statement.arguments.ArgumentType;
import com.kassmon.asm.core.statement.commands.CommandStatement;

public class Move extends CommandStatement{
	
	private final Argument registerAddress, value;
	
	public Move(int lineNumber, Argument registerAddress, Argument value) {
		super(lineNumber, true);
		this.registerAddress = registerAddress;
		this.value = value;
	}

	@Override
	public void execute() {
		if (registerAddress.getType() != ArgumentType.REGISTER) 
			throw new IllegalArgumentException("First argument must be a register");
		int address = getValueFromArgument(registerAddress);
		int val = getValueFromArgument(value);
		registers.write(address, val);
	}

	@Override
	public String toString() {
		return "move " + registerAddress.toString() + " " + value;
	}

}
