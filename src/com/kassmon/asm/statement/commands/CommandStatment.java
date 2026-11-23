package com.kassmon.asm.statement.commands;

import com.kassmon.asm.exceptions.ScriptException;
import com.kassmon.asm.runtime.data.*;
import com.kassmon.asm.statement.Statment;
import com.kassmon.asm.statement.arguments.Argument;

public abstract class CommandStatment extends Statment {
	
	protected Registers registers;
	protected Memory memory;
	protected LabelPointers labelPointers;
	protected boolean advanceProgramCounter = false;
	
	public CommandStatment(int lineNumber, boolean advanceProgramCounter) {
		super(lineNumber);
		this.advanceProgramCounter = advanceProgramCounter;
	}
	
	public void setRegisters(Registers registers) {
		this.registers = registers;
	}
	
	public void setMemory(Memory memory) {
		this.memory = memory;
	}
	
	public void setLabelPointers(LabelPointers labelPointers) {
		this.labelPointers = labelPointers;
	}
	
	public boolean advanceProgramCounter() {
		return advanceProgramCounter;
	}
	
	public abstract void execute();
	
	protected int getValueFromArgument(Argument argument) {
		switch (argument.getType()) {
		case LITERAL:
			return argument.getValue();
		case REGISTER:
			return registers.read(argument.getValue());
		default:
			throw new ScriptException("Invalid argument type");
		}
	}
	
}
