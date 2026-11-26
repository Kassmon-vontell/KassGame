package com.kassmon.asm.core.statement.commands.basic.math;

import com.kassmon.asm.exceptions.ScriptException;
import com.kassmon.asm.core.statement.arguments.Argument;
import com.kassmon.asm.core.statement.arguments.ArgumentType;
import com.kassmon.asm.core.statement.commands.CommandStatement;

public class Or extends CommandStatement{
	
	private final Argument input1, input2;
	
	public Or(int lineNumber, Argument input1, Argument input2) {
		super(lineNumber, true);
		this.input1 = input1;
		this.input2 = input2;
	}

	@Override
	public void execute() {
		if (input1.getType() != ArgumentType.REGISTER) 
			throw new ScriptException("First argument must be a register");
		int value1 = getValueFromArgument(input1);
		int value2 = getValueFromArgument(input2);
		
		registers.write(input1.getValue(), (value1 | value2));
		
	}

	@Override
	public String toString() {
		return  "or " + input1.toString() + " " + input2.toString();
	}

}