package com.kassmon.asm.staments.commands;

import com.kassmon.asm.plugin.PluginManager;
import com.kassmon.asm.runtime.data.LabelPointers;
import com.kassmon.asm.runtime.data.Registers;
import com.kassmon.asm.staments.Statment;

public abstract class CommandStatment extends Statment {
	
	protected Registers registers;
	protected LabelPointers labelPointers;
	protected PluginManager pluginManager;
	protected boolean advanceProgramCounter = false;
	
	public CommandStatment(int lineNumber, boolean advanceProgramCounter) {
		super(lineNumber);
		this.advanceProgramCounter = advanceProgramCounter;
	}
	
	public void setRegisters(Registers registers) {
		this.registers = registers;
	}
	
	public void setLabelPointers(LabelPointers labelPointers) {
		this.labelPointers = labelPointers;
	}
	
	public void setPluginManager(PluginManager pluginManager) {
		this.pluginManager = pluginManager;
	}
	
	public abstract void execute();
	
}
