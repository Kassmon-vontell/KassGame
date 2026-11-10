package com.kassmon.asm.staments.commands.math;

import com.kassmon.asm.staments.commands.CommandStatment;

public class Add extends CommandStatment {
	
	private int registerPointerSrc1, registerPointerSrc2, registerPointerDest;
	
	public Add(int lineNumber, int registerPointerSrc1, int registerPointerSrc2, int registerPointerDest) {
		super(lineNumber, true);
		this.registerPointerSrc1 = registerPointerSrc1;
		this.registerPointerSrc2 = registerPointerSrc2;
		this.registerPointerDest = registerPointerDest;
	}

	@Override
	public void execute() {
		int value1 = registers.read(registerPointerSrc1);
		int value2 = registers.read(registerPointerSrc2);
		registers.write(registerPointerDest, (value1 + value2));
	}

	@Override
	public String toString() {
		//TODO: add a proper toString method
		return null;
	}

}
