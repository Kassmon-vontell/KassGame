package com.kassmon.asm.core.statement.commands;

import com.kassmon.asm.core.runtime.data.LabelPointers;
import com.kassmon.asm.core.runtime.data.Memory;
import com.kassmon.asm.core.runtime.data.Registers;
import com.kassmon.asm.core.statement.Statement;
import com.kassmon.asm.core.statement.arguments.Argument;

public abstract class CommandStatement extends Statement{
	
	protected Registers registers;
	protected Memory memory;
	protected LabelPointers labelPointers;
	protected boolean advanceProgramCounter;
	
	public CommandStatement(int lineNumber, boolean advanceProgramCounter) {
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
		return switch(argument.getType()){
			case LITERAL -> argument.getValue();
			case REGISTER -> registers.read(argument.getValue());
		};
	}
	
}
