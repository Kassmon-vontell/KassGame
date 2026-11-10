package com.kassmon.asm.runtime.data;

public class Registers {
	
	private int[] registers;
	private int addressRegister;
	
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
	
}
