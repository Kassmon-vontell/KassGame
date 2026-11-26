package com.kassmon.asm.core.statement.commands.basic.math;

import com.kassmon.asm.exceptions.ScriptException;
import com.kassmon.asm.core.statement.arguments.Argument;
import com.kassmon.asm.core.statement.arguments.ArgumentType;
import com.kassmon.asm.core.statement.commands.CommandStatement;

public class Not extends CommandStatement{
	
	private final Argument input;
	
	public Not(int lineNumber , Argument input) {
		super(lineNumber, true);
		this.input = input;
	}

	@Override
	public void execute() {
		if (input.getType() != ArgumentType.REGISTER) 
			throw new ScriptException("argument must be a register");
		int value = getValueFromArgument(input);
		registers.write(input.getValue(), ~value);
	}

	@Override
	public String toString() {
		return "not " + input.toString();
	}

}
