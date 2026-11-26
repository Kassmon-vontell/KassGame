package com.kassmon.asm.core.statement.commands.basic.control;

import com.kassmon.asm.core.statement.commands.CommandStatement;

public class Eof extends CommandStatement{
	
	public Eof(int lineNumber) {
		super(lineNumber, false);
	}
	
	@Override
	public void execute(){
		registers.setTerminated(true);
	}
	
	@Override
	public String toString(){
		return "";
	}
}
