package com.kassmon.asm.core.runtime;

import com.kassmon.asm.core.lexer.Lexer;
import com.kassmon.asm.core.parser.Parser;
import com.kassmon.asm.core.runtime.data.*;
import com.kassmon.asm.core.statement.Statement;
import com.kassmon.asm.core.statement.commands.CommandStatement;
import com.kassmon.asm.core.statement.commands.basic.control.Eof;
import com.kassmon.asm.core.statement.info.Label;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class RuntimeInterpreter{
	
	protected final LabelPointers labelPointers;
	protected final Memory memory;
	protected final Registers registers;
	
	protected final ArrayList<CommandStatement> script;
	
	protected boolean hasError = false;
	
	public RuntimeInterpreter(String script) {
		labelPointers = new LabelPointers();
		memory = new Memory(0x1000000);
		registers = new Registers(0x10);
		this.script = new ArrayList<>();
		loadScript(script);
		
	}
	
	protected void loadScript(String script) {
		Lexer lexer = new Lexer(script);
		Parser parser = new Parser(lexer);
		if (!lexer.verifyInput().isEmpty()){
			hasError = true;
			return;
		}
		while(true) {
			Statement statement = parser.parse();
			if (statement instanceof Label label)
				labelPointers.addLabelPointer(label.getLabel(), this.script.size());
			if (statement instanceof CommandStatement commandStatement)
				this.script.add(commandStatement);
			if (statement instanceof Eof) break;
		}
		for(CommandStatement commandStatement : this.script) {
			commandStatement.setLabelPointers(this.labelPointers);
			commandStatement.setMemory(this.memory);
			commandStatement.setRegisters(this.registers);
		}
	}
	
	public void executeScriptStatement() {
		if (hasError) return;
		if(registers.isTerminated()) return;
		if(registers.isWaiting()) return;
		script.get(registers.getProgramCounter()).execute();
		if (script.get(registers.getProgramCounter()).advanceProgramCounter())
			registers.setProgramCounter(registers.getProgramCounter() + 1);
	}
	
	public void executeScript() {
		if (hasError) return;
		while (true) {
			if (registers.isTerminated()) return;
			if (registers.isWaiting()) return;
			CommandStatement cs = script.get(registers.getProgramCounter());
			cs.execute();
			if (cs.advanceProgramCounter())
				registers.setProgramCounter(registers.getProgramCounter() + 1);
		}
	}
	
	public LabelPointers getLabelPointers() {
		return labelPointers;
	}
	
	public Memory getMemory() {
		return memory;
	}
	
	public Registers getRegisters() {
		return registers;
	}
	
}
