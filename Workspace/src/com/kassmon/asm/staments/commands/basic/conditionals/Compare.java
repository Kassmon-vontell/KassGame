package com.kassmon.asm.staments.commands.basic.conditionals;

import com.kassmon.asm.staments.commands.CommandStatment;

public class Compare extends CommandStatment {
	
	private int cmp1, cmp2;
	
	public Compare(int lineNumber, int cmp1, int cmp2) {
		super(lineNumber, true);
		this.cmp1 = cmp1;
		this.cmp2 = cmp2;
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
