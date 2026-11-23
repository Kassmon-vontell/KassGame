package com.kassmon.asm.statement.commands.basic.math;

import com.kassmon.asm.exceptions.ScriptException;
import com.kassmon.asm.statement.arguments.Argument;
import com.kassmon.asm.statement.arguments.ArgumentType;
import com.kassmon.asm.statement.commands.CommandStatment;

public class Not extends CommandStatment {
	
	private Argument input;
	
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
		//TODO: implement toString
		return null;
	}

}
