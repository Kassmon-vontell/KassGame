package com.kassmon.asm.runtime.data;

public class Registers {
	
	private int[] registers;
	private int addressRegister;
	
	private boolean isEqual = false;
	private boolean isGreater = false;
	private boolean isLess = false;
	
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
	
	public int getAddressRegister() {
		return addressRegister;
	}
	
	public void setAddressRegister(int addressRegister) {
		this.addressRegister = addressRegister;
	}
	
	public boolean isEqual() {
		return isEqual;
	}
	
	public void setEqual(boolean isEqual) {
		this.isEqual = isEqual;
	}
	
	public boolean isGreater() {
		return isGreater;
	}
	
	public void setGreater(boolean isGreater) {
		this.isGreater = isGreater;
	}
	
	public boolean isLess() {
		return isLess;
	}
	
	public void setLess(boolean isLess) {
		this.isLess = isLess;
	}
	
}
