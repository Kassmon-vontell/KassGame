package com.kassmon.asm.core.runtime.data;


public class Registers {
	
	private boolean terminated = false;
	private boolean waiting = false;
	
	private boolean equal = false;
	private boolean greater = false;
	private boolean less = false;
	
	private int[] registers;
	private int ProgramCounter;
	
	
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
		equal = value;
	}
	
	public void setGreater(boolean value) {
		greater = value;
	}
	
	public void setLess(boolean value) {
		less = value;
	}
	
	public boolean isEqual() {
		return equal;
	}
	
	public boolean isNotEqual() {
		return !equal;
	}
	
	public boolean isGreater() {
		return greater;
	}
	
	public boolean isLess() {
		return less;
	}
	
	
	
	public void setTerminated(boolean isTerminated) {
		terminated = isTerminated;
	}
	
	public boolean isTerminated() {
		return terminated;
	}
	
	public void setWaiting(boolean isWaiting) {
		waiting = isWaiting;
	}
	
	public boolean isWaiting() {
		return waiting;
	}
	
}
