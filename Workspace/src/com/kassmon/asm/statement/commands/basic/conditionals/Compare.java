package com.kassmon.asm.statement.commands.basic.conditionals;

import com.kassmon.asm.statement.arguments.Argument;
import com.kassmon.asm.statement.commands.CommandStatment;

public class Compare extends CommandStatment {
	
	private Argument cmp1, cmp2;
	
	public Compare(int lineNumber, Argument cmp1, Argument cmp2) {
		super(lineNumber, true);
		this.cmp1 = cmp1;
		this.cmp2 = cmp2;
	}

	@Override
	public void execute() {
		int int1 = getValueFromArgument(cmp1);
		int int2 = getValueFromArgument(cmp2);
		registers.setEqual(int1 == int2);
		registers.setGreater(int1 > int2);
		registers.setLess(int1 < int2);
	}

	@Override
	public String toString() {
		//TODO: add toString method
		return null;
	}

}
