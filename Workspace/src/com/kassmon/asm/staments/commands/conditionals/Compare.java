package com.kassmon.asm.staments.commands.conditionals;

import com.kassmon.asm.staments.commands.CommandStatment;

public class Compare extends CommandStatment {
	
	private int cmp1, cmp2;
	
	public Compare(int lineNumber) {
		super(lineNumber, true);
	}

	@Override
	public void execute() {
		int int1 = registers.read(cmp1);
		int int2 = registers.read(cmp2);
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
