package com.kassmon.asm.core.runtime.data;

@SuppressWarnings("unused")
public class Registers {
	
	private final static int terminated = 0b00000001;
	private final static int waiting = 0b00000010;
	
	private final static int bitMaskEqual = 0b100000000;
	private final static int bitMaskGreater = 0b1000000000;
	private final static int bitMaskLess = 0b10000000000;
	
	private int[] registers;
	private int ProgramCounter;
	private int flags;
	
	public Registers(int size) {
		this.registers = new int[size];
	}
	
	public int read(int index) {
		return registers[index];
	}
	
	public void write(int index, int value) {
		registers[index] = value;
	}
	
	public int[] getRegisters() {
		return registers;
	}
	
	public void setRegisters(int[] registers) {
		this.registers = registers;
	}
	
	public int getProgramCounter() {
		return ProgramCounter;
	}
	
	public void setProgramCounter(int programCounter) {
		ProgramCounter = programCounter;
	}
	
	
	
	public void setEqual(boolean value) {
		if(value) {
			flags |= bitMaskEqual;
		} else {
			flags &= ~bitMaskEqual;
		}
	}
	
	public void setGreater(boolean value) {
		if(value) {
			flags |= bitMaskGreater;
		} else {
			flags &= ~bitMaskGreater;
		}
	}
	
	public void setLess(boolean value) {
		if(value) {
			flags |= bitMaskLess;
		} else {
			flags &= ~bitMaskLess;
		}
	}
	
	public boolean isEqual() {
		return (flags & bitMaskEqual) != 0;
	}
	
	public boolean isNotEqual() {
		return (flags & bitMaskEqual) == 0;
	}
	
	public boolean isGreater() {
		return (flags & bitMaskGreater) != 0;
	}
	
	public boolean isLess() {
		return (flags & bitMaskLess) != 0;
	}
	
	
	
	public void setTerminated(boolean isTerminated) {
		if(isTerminated) {
			flags |= terminated;
		} else {
			flags &= ~terminated;
		}
	}
	
	public boolean isTerminated() {
		return (flags & terminated) != 0;
	}
	
	public void setWaiting(boolean isWaiting) {
		if(isWaiting) {
			flags |= waiting;
		} else {
			flags &= ~waiting;
		}
	}
	
	public boolean isWaiting() {
		return (flags & waiting) != 0;
	}
	
}
