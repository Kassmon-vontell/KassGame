package com.kassmon.asm.plugin;

public abstract class Plugin {
	
	protected int startMemoryAddress;
	protected int memorySize;
	
	public Plugin(int startMemoryAddress, int memorySize) {
		this.startMemoryAddress = startMemoryAddress;
	}
	
	public int getStartMemoryAddress() {
		return this.startMemoryAddress;
	}
	
	public abstract int read(int pointer);
	public abstract void write(int pointer, int value);
	
	public int getMemoryStartAddress() {
		return this.startMemoryAddress;
	}
	
	public int getMemoryEndAddress() {
		return this.startMemoryAddress + this.memorySize - 1;
	}
	
	public int getMemorySize() {
		return this.memorySize;
	}
	
}
